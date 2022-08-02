package com.ndeng.pointsService.repository;

import com.ndeng.pointsService.entity.TransactionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for transactions.
 */
@Repository
public interface TransactionRepository extends CrudRepository<TransactionEntity, String> {
    List<TransactionEntity> findAllByPayer(String payer);
    List<TransactionEntity> findAllByCustomer(String customer);
}
