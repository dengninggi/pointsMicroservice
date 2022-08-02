package com.ndeng.pointsService.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Customer-related requests.
 */
@Data
@AllArgsConstructor @NoArgsConstructor
public class CustomerRequest {
    private String customer;
}
