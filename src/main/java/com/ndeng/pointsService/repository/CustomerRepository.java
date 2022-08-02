package com.ndeng.pointsService.repository;

import com.ndeng.pointsService.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for customers.
 */
@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, String> {
    CustomerEntity findByCustomer(String customer);
}
