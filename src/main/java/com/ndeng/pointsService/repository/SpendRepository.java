package com.ndeng.pointsService.repository;

import com.ndeng.pointsService.entity.SpendEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for spends.
 */
@Repository
public interface SpendRepository extends CrudRepository<SpendEntity, String> {
    List<SpendEntity> findAllByCustomer(String customer);
}
