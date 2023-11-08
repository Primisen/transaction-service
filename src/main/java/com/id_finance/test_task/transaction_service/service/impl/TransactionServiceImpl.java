package com.id_finance.test_task.transaction_service.service.impl;

import com.id_finance.test_task.transaction_service.dto.LimitExceededTransactionDto;
import com.id_finance.test_task.transaction_service.entity.Account;
import com.id_finance.test_task.transaction_service.repository.TransactionRepository;
import com.id_finance.test_task.transaction_service.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<LimitExceededTransactionDto> getLimitExceededTransactions(Account account) {
        return transactionRepository.getLimitExceededTransactions(account);
    }
}
