package com.ndeng.pointsService.service;

import com.ndeng.pointsService.dto.TransactionDto;
import com.ndeng.pointsService.request.SpendRequest;
import com.ndeng.pointsService.response.BalanceResponse;
import com.ndeng.pointsService.response.BalanceDetail;
import com.ndeng.pointsService.response.SpendResponse;

/**
 * Balance-related service.
 */
public interface BalanceService {
    /**
     * Get balance details of a customer
     * @param customer the customer to be retrieved
     * @return the balance details
     */
    BalanceResponse getBalance(String customer);

    /**
     * Save the balance of a customer
     * @param customer the customer to be saved for
     * @param balanceDetail the balance detail to be saved
     */
    void saveBalance(String customer, BalanceDetail balanceDetail);

    /**
     * Update the balance of a customer after a transaction
     * @param transactionDto the transaction to be processed
     * @return the updated balance details
     */
    BalanceResponse updateBalance(TransactionDto transactionDto);

    /**
     * Update the balance of a customer after spend
     * @param request the spend request to be processed
     * @return the spend details
     */
    SpendResponse updateBalance(SpendRequest request);
}
