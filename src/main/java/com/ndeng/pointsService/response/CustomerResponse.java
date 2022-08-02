package com.ndeng.pointsService.response;

import com.ndeng.pointsService.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Customer-related responses.
 */
@Data @NoArgsConstructor @AllArgsConstructor
public class CustomerResponse {
    private String customer;
    private int totalPoints;

    public CustomerResponse(CustomerEntity customerEntity) {
        this.customer = customerEntity.getCustomer();
        this.totalPoints = customerEntity.getTotalPoints();
    }
}
