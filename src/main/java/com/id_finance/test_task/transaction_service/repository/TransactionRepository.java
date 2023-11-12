package com.id_finance.test_task.transaction_service.repository;

import com.id_finance.test_task.transaction_service.dto.LimitExceededTransactionDto;
import com.id_finance.test_task.transaction_service.entity.Account;
import com.id_finance.test_task.transaction_service.entity.Limit;
import com.id_finance.test_task.transaction_service.entity.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

    @Query(value = "SELECT t  FROM Transaction t WHERE t.accountFrom=?1 AND t.limitIsExceeded=true")
    List<Transaction> getLimitExceededTransactions(Account account);
}
