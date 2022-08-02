package com.ndeng.pointsService.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Balance-related responses.
 */
@Data @NoArgsConstructor
public class BalanceResponse {
    private String customer;
    private int totalPoints;
    private Map<String, Integer> payerBalance = new HashMap<>();

    public void combineBalanceDetails(List<BalanceDetail> balanceDetailList) {
        for (BalanceDetail balanceDetail : balanceDetailList) {
            String payer = balanceDetail.getPayer();
            payerBalance.put(payer, payerBalance.getOrDefault(payer, 0) + balanceDetail.getPoints());
        }
    }
}
