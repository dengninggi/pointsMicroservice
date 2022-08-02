package com.ndeng.pointsService.request;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Spend-related requests.
 */
@Data
@AllArgsConstructor
public class SpendRequest {
    private String customer;
    private int points;
}
