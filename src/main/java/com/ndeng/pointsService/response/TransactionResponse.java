package com.ndeng.pointsService.response;

import lombok.Data;

/**
 * Transaction-related responses.
 */
@Data
public class TransactionResponse {
    private String customer;
    private int totalPoints;
}
