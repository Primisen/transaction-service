package com.id_finance.test_task.transaction_service.repository;

import com.id_finance.test_task.transaction_service.entity.ExchangeRate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRateRepository extends CrudRepository<ExchangeRate, Integer> {
}
