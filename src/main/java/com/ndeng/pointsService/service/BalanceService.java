package com.ndeng.pointsService.service;

import com.ndeng.pointsService.dto.TransactionDto;
import com.ndeng.pointsService.request.SpendRequest;
import com.ndeng.pointsService.response.BalanceResponse;
import com.ndeng.pointsService.response.BalanceDetail;
import com.ndeng.pointsService.response.SpendResponse;

public interface BalanceService {
    BalanceResponse getBalance(String customer);
    void saveBalance(String customer, BalanceDetail balanceDetail);
    BalanceResponse updateBalance(TransactionDto transactionDto);
    SpendResponse updateBalance(SpendRequest request);
}
