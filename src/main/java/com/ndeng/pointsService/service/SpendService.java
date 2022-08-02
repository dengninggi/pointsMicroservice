package com.ndeng.pointsService.service;

import com.ndeng.pointsService.entity.SpendEntity;
import com.ndeng.pointsService.request.SpendRequest;

public interface SpendService {
    void saveSpend(SpendRequest request);
}
