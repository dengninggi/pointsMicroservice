package com.ndeng.pointsService.service;

import com.ndeng.pointsService.dto.TransactionDto;
import com.ndeng.pointsService.entity.BalanceEntity;
import com.ndeng.pointsService.repository.BalanceRepository;
import com.ndeng.pointsService.request.SpendRequest;
import com.ndeng.pointsService.response.BalanceResponse;
import com.ndeng.pointsService.response.BalanceDetail;
import com.ndeng.pointsService.response.CustomerResponse;
import com.ndeng.pointsService.response.SpendResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class BalanceServiceImpl implements BalanceService{

    @Autowired
    private BalanceRepository balanceRepository;
    @Autowired
    private CustomerService customerService;

    @Override
    public BalanceResponse getBalance(String customer) {
        CustomerResponse customerResponse = customerService.getCustomer(customer);
        List<BalanceEntity> balanceEntityList = balanceRepository.findAllByCustomerOrderByInstant(customer);
        List<BalanceDetail> balanceDetailList = new ArrayList<>();
        for (BalanceEntity entity : balanceEntityList) {
            BalanceDetail balanceDetail = new BalanceDetail(entity);
            balanceDetailList.add(balanceDetail);
        }
        BalanceResponse response = new BalanceResponse();
        response.setCustomer(customer);
        response.setTotalPoints(customerResponse.getTotalPoints());
        response.combineBalanceDetails(balanceDetailList);
        return response;
    }

    @Override
    public void saveBalance(String customer, BalanceDetail balanceDetail) {
        Instant instant = Instant.parse(balanceDetail.getTimestamp());
        BalanceEntity entity = balanceRepository.findByCustomerAndInstant(customer, instant);
        if (entity == null) {
            entity = new BalanceEntity(customer, balanceDetail);
        } else if (entity.getPoints() == balanceDetail.getPoints()) {
            return;
        }
        balanceRepository.save(entity);
    }

    @Override
    public BalanceResponse updateBalance(TransactionDto transactionDto) {
        String customer = transactionDto.getCustomer();
        int points = transactionDto.getPoints();
        if (points > 0) {
            BalanceDetail balanceDetail = new BalanceDetail(transactionDto);
            saveBalance(customer, balanceDetail);
        } else {
            String payer = transactionDto.getPayer();
            List<BalanceEntity> balanceEntityList = balanceRepository.findAllByCustomerAndPayerOrderByInstant(customer, payer);
            for (BalanceEntity entity : balanceEntityList) {
                if (points == 0) {
                    break;
                }
                if (points + entity.getPoints() > 0){
                    entity.setPoints(entity.getPoints() + points);
                    balanceRepository.save(entity);
                    points = 0;
                } else {
                    points += entity.getPoints();
                    balanceRepository.delete(entity);
                }
            }
        }
        return getBalance(customer);
    }

    @Override
    public SpendResponse updateBalance(SpendRequest request) {
        String customer = request.getCustomer();

        SpendResponse response = new SpendResponse();
        response.setCustomer(customer);

        int points = request.getPoints();
        // update balance entities
        List<BalanceEntity> balanceEntityList = balanceRepository.findAllByCustomerOrderByInstant(customer);
        for (BalanceEntity balanceEntity : balanceEntityList) {
            if (points <= 0) {
                break;
            }
            if (points >= balanceEntity.getPoints()) {
                response.add(balanceEntity.getPayer(), balanceEntity.getPoints());
                points -= balanceEntity.getPoints();
                balanceRepository.delete(balanceEntity);
            } else {
                response.add(balanceEntity.getPayer(), points);
                balanceEntity.setPoints(balanceEntity.getPoints() - points);
                balanceRepository.save(balanceEntity);
                points = 0;
            }
        }
        return response;
    }
}
