package com.id_finance.test_task.transaction_service.service;

import com.id_finance.test_task.transaction_service.dto.LimitExceededTransactionDto;
import com.id_finance.test_task.transaction_service.entity.Account;
import com.id_finance.test_task.transaction_service.entity.Transaction;

import java.util.List;

public interface TransactionService {

    List<LimitExceededTransactionDto> getLimitExceededTransactions(Account account);

    void save(Transaction transaction);
}
