package com.ndeng.pointsService.service;

import com.ndeng.pointsService.entity.SpendEntity;
import com.ndeng.pointsService.repository.SpendRepository;
import com.ndeng.pointsService.request.SpendRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpendServiceImpl implements SpendService {
    @Autowired
    private SpendRepository spendRepository;
    @Override
    public void saveSpend(SpendRequest request) {
        SpendEntity entity = new SpendEntity(request);
        spendRepository.save(entity);
    }
}
