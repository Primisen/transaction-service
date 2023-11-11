package com.id_finance.test_task.transaction_service.repository;

import com.id_finance.test_task.transaction_service.entity.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LimitRepository extends JpaRepository<Limit, Integer> {
}
