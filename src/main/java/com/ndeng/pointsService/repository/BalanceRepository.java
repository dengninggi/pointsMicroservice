package com.ndeng.pointsService.repository;

import com.ndeng.pointsService.entity.BalanceEntity;
import org.springframework.data.repository.CrudRepository;

import java.time.Instant;
import java.util.List;

/**
 * Repository for banlaces.
 */
public interface BalanceRepository extends CrudRepository<BalanceEntity, String> {
    BalanceEntity findByCustomerAndInstant(String customer, Instant instant);
    List<BalanceEntity> findAllByCustomerOrderByInstant(String customer);
    List<BalanceEntity> findAllByCustomerAndPayerOrderByInstant(String customer, String payer);
}
