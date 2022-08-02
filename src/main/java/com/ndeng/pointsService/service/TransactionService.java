package com.ndeng.pointsService.service;

import com.ndeng.pointsService.dto.TransactionDto;
import com.ndeng.pointsService.entity.TransactionEntity;
import com.ndeng.pointsService.request.TransactionRequest;

import java.util.List;

public interface TransactionService {
    void saveTransaction(TransactionDto transactionDto);
    TransactionEntity findByTransactionId(String transactionId);
    List<TransactionEntity> findAllByCustomer(String customer);
    List<TransactionEntity> findAllByPayer(String payer);
    int getTotalBalance(String customer);
    int getTotalDebt(String payer);
}
