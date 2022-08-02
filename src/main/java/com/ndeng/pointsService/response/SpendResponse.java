package com.ndeng.pointsService.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * Spend-related responses.
 */
@Data @NoArgsConstructor
public class SpendResponse {
    private String customer;
    private Map<String, Integer> spendOnPayers = new HashMap<>();

    public void add(String customer, int points){
        spendOnPayers.put(customer, spendOnPayers.getOrDefault(customer, 0) - points);
    }
}
