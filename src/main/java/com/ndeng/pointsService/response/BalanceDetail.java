package com.ndeng.pointsService.response;

import com.ndeng.pointsService.dto.TransactionDto;
import com.ndeng.pointsService.entity.BalanceEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Balance details for responses.
 */
@Data @NoArgsConstructor
public class BalanceDetail {
    private String payer;
    private int points;
    private String timestamp;

    public BalanceDetail (BalanceEntity balanceEntity) {
        this.payer = balanceEntity.getPayer();
        this.points = balanceEntity.getPoints();
        this.timestamp = balanceEntity.getInstant().toString();
    }

    public BalanceDetail(TransactionDto transactionDto) {
        this.payer = transactionDto.getPayer();
        this.points = transactionDto.getPoints();
        this.timestamp = transactionDto.getInstant().toString();
    }
}
