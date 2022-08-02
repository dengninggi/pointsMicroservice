package com.ndeng.pointsService.dto;

import com.ndeng.pointsService.request.TransactionRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * Data transfer object for transactions
 */
@Data
@NoArgsConstructor
public class TransactionDto {
    private String customer;
    private String payer;
    private int points;
    private Instant instant;

    /**
     * Builder from a transaction request
     * @param request
     */
    public TransactionDto(TransactionRequest request) {
        this.customer = request.getCustomer();
        this.payer = request.getPayer();
        points = request.getPoints();
        instant = Instant.parse(request.getTimestamp());
    }
}
