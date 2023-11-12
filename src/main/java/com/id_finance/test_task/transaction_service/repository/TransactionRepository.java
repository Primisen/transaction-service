package com.id_finance.test_task.transaction_service.repository;

import com.id_finance.test_task.transaction_service.dto.LimitExceededTransactionDto;
import com.id_finance.test_task.transaction_service.entity.Account;
import com.id_finance.test_task.transaction_service.entity.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

    @Query(value = "SELECT * FROM transaction JOIN account ON transaction.account_from_id = account.id JOIN limits ON account.id = limits.account_id WHERE account_from_id=(?1)", nativeQuery = true)
    List<LimitExceededTransactionDto> getLimitExceededTransactions(Account account);
}
