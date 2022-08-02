package com.ndeng.pointsService.request;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Transaction-related requests.
 */
@Data @AllArgsConstructor
public class TransactionRequest {
    private String customer;
    private String payer;
    private int points;
    private String timestamp;
}
