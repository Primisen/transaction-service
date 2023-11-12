package com.id_finance.test_task.transaction_service.repository;

import com.id_finance.test_task.transaction_service.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {
}
