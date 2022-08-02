package com.ndeng.pointsService.service;

import com.ndeng.pointsService.dto.TransactionDto;
import com.ndeng.pointsService.entity.TransactionEntity;

import java.util.List;

/**
 * Transaction-related service
 */
public interface TransactionService {
    /**
     * Sace a transaction
     * @param transactionDto the transaction to be saved
     */
    void saveTransaction(TransactionDto transactionDto);

    /**
     * Find a transaction according to the id
     * @param transactionId the id of the transaction
     * @return the transaction from the database
     */
    TransactionEntity findByTransactionId(String transactionId);

    /**
     * Find all transactions of a customer
     * @param customer the customer's name
     * @return all transactions of the customer
     */
    List<TransactionEntity> findAllByCustomer(String customer);

    /**
     * Find all transactions of a payer
     * @param payer the payer's name/id
     * @return all transactions of the payer
     */
    List<TransactionEntity> findAllByPayer(String payer);
}
