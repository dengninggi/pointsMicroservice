package com.ndeng.pointsService.service;

import com.ndeng.pointsService.request.SpendRequest;

/**
 * Spend-related service
 */
public interface SpendService {
    /**
     * Save a spend
     * @param request the spend request to be processed
     */
    void saveSpend(SpendRequest request);
}
