package com.ndeng.pointsService.service;

import com.ndeng.pointsService.dto.TransactionDto;
import com.ndeng.pointsService.entity.TransactionEntity;
import com.ndeng.pointsService.repository.TransactionRepository;
import com.ndeng.pointsService.request.TransactionRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void saveTransaction(TransactionDto transactionDto) {
        TransactionEntity entity = new TransactionEntity();
        BeanUtils.copyProperties(transactionDto, entity);
        transactionRepository.save(entity);
    }

    @Override
    public TransactionEntity findByTransactionId(String transactionId) {
        return null;
    }

    @Override
    public List<TransactionEntity> findAllByCustomer(String customer) {
        return null;
    }

    @Override
    public List<TransactionEntity> findAllByPayer(String payer) {
        return null;
    }

    @Override
    public int getTotalBalance(String customer) {
        return 0;
    }

    @Override
    public int getTotalDebt(String payer) {
        return 0;
    }
}
