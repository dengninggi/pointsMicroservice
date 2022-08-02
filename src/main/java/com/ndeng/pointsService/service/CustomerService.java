package com.ndeng.pointsService.service;

import com.ndeng.pointsService.dto.TransactionDto;
import com.ndeng.pointsService.exception.PointsException;
import com.ndeng.pointsService.request.SpendRequest;
import com.ndeng.pointsService.response.CustomerResponse;

public interface CustomerService {
    CustomerResponse createCustomer(String customer);
    CustomerResponse getCustomer(String customer);
    CustomerResponse updateCustomer(TransactionDto transactionDto) throws PointsException;
    CustomerResponse updateCustomer(SpendRequest request) throws PointsException;
}
