package com.ndeng.pointsService.service;

import com.ndeng.pointsService.dto.TransactionDto;
import com.ndeng.pointsService.entity.CustomerEntity;
import com.ndeng.pointsService.exception.PointsException;
import com.ndeng.pointsService.repository.CustomerRepository;
import com.ndeng.pointsService.request.SpendRequest;
import com.ndeng.pointsService.response.CustomerResponse;
import com.ndeng.pointsService.utility.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerResponse createCustomer(String customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        if (customerRepository.existsById(customer)) {
            customerEntity = customerRepository.findByCustomer(customer);
        } else {
            customerEntity.setCustomer(customer);
            customerEntity.setTotalPoints(0);
            customerRepository.save(customerEntity);
        }
        return new CustomerResponse(customerEntity);
    }

    @Override
    public CustomerResponse getCustomer(String customer) {
        CustomerEntity customerEntity = customerRepository.findByCustomer(customer);
        return new CustomerResponse(customerEntity);
    }

    @Override
    public CustomerResponse updateCustomer(TransactionDto transactionDto) throws PointsException {
        String customer = transactionDto.getCustomer();
        String payer = transactionDto.getPayer();
        if (!customerRepository.existsById(customer)) {
            throw new PointsException(HttpStatus.BAD_REQUEST, ErrorMessage.CUSTOMER_NOT_EXIST);
        }
        CustomerResponse customerResponse = getCustomer(customer);
        if (transactionDto.getPoints() + customerResponse.getTotalPoints() < 0) {
            throw new PointsException(HttpStatus.BAD_REQUEST, ErrorMessage.POINTS_INEFFICIENCY);
        }
        CustomerEntity customerEntity = customerRepository.findByCustomer(customer);
        customerEntity.setTotalPoints(customerEntity.getTotalPoints() + transactionDto.getPoints());
        CustomerEntity savedCustomerEntity = customerRepository.save(customerEntity);
        return new CustomerResponse(savedCustomerEntity);
    }

    @Override
    public CustomerResponse updateCustomer(SpendRequest request) throws PointsException {
        String customer = request.getCustomer();
        if (!customerRepository.existsById(customer)) {
            throw new PointsException(HttpStatus.BAD_REQUEST, ErrorMessage.CUSTOMER_NOT_EXIST);
        }
        CustomerResponse customerResponse = getCustomer(customer);
        if (request.getPoints() > customerResponse.getTotalPoints()) {
            throw new PointsException(HttpStatus.BAD_REQUEST, ErrorMessage.POINTS_INEFFICIENCY);
        }
        CustomerEntity customerEntity = customerRepository.findByCustomer(customer);
        customerEntity.setTotalPoints(customerEntity.getTotalPoints() - request.getPoints());
        CustomerEntity savedCustomerEntity = customerRepository.save(customerEntity);
        return new CustomerResponse(savedCustomerEntity);
    }
}
