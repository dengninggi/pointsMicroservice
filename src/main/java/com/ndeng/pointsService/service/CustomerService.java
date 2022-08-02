package com.ndeng.pointsService.service;

import com.ndeng.pointsService.dto.TransactionDto;
import com.ndeng.pointsService.exception.PointsException;
import com.ndeng.pointsService.request.SpendRequest;
import com.ndeng.pointsService.response.CustomerResponse;

/**
 * Customer-related service.
 */
public interface CustomerService {
    /**
     * Create a customer
     * @param customer the customer's name
     * @return the new customer
     */
    CustomerResponse createCustomer(String customer);

    /**
     * Get a customer's information
     * @param customer the customer's name
     * @return the customer's information
     */
    CustomerResponse getCustomer(String customer);

    /**
     * Update a customer due to a transaction
     * @param transactionDto the transaction to be processed
     * @return the updated customer information
     * @throws PointsException any possible exceptions
     */
    CustomerResponse updateCustomer(TransactionDto transactionDto) throws PointsException;
    /**
     * Update a customer due to a spend
     * @param request the spend request to be processed
     * @return the updated customer information
     * @throws PointsException any possible exceptions
     */
    CustomerResponse updateCustomer(SpendRequest request) throws PointsException;
}
