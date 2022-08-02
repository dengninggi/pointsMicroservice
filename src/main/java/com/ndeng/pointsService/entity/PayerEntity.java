package com.ndeng.pointsService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * The entity for payers
 */
@Data @AllArgsConstructor @NoArgsConstructor
public class PayerEntity {
    /** the identity for a payer. */
    @Id
    private String payer;
    /** the number of points should be paid by the payer. It's what customers have redeemed. */
    @Column(nullable = false)
    private int totalDue;
    /** the number of points might be paid the payer. It's what customers have earned. */
    @Column(nullable = false)
    private int totalDebt;
}
