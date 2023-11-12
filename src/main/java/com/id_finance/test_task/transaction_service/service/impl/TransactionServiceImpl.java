package com.id_finance.test_task.transaction_service.service.impl;

import com.id_finance.test_task.transaction_service.dto.LimitExceededTransactionDto;
import com.id_finance.test_task.transaction_service.entity.Account;
import com.id_finance.test_task.transaction_service.entity.Transaction;
import com.id_finance.test_task.transaction_service.repository.AccountRepository;
import com.id_finance.test_task.transaction_service.repository.TransactionRepository;
import com.id_finance.test_task.transaction_service.service.TransactionService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

    @Autowired
    TransactionServiceImpl(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public List<LimitExceededTransactionDto> getLimitExceededTransactions(Account account) {
        return transactionRepository.getLimitExceededTransactions(account);
    }

    @Override
    @Transactional
    public void save(Transaction transaction) {

        transaction.setDateTime(ZonedDateTime.now());

        Account accountFrom = accountRepository.findById(transaction.getAccountFrom().getId())
                .orElseThrow(() -> new RuntimeException(String.format("Account with id = %s not found", transaction.getAccountFrom().getId())));

        if (transactionLimitsIsExceeded(accountFrom, transaction)) {
            transaction.setLimitExceeded(true);

        } else {
            transaction.setLimitExceeded(false);

            Account accountTo = accountRepository.findById(transaction.getAccountTo().getId())
                    .orElseThrow(() -> new RuntimeException(String.format("Account with id = %s not found", transaction.getAccountTo().getId())));
            transferMoney(accountFrom, accountTo, transaction.getSum());
        }

        transactionRepository.save(transaction);
        logger.info("Saved transaction: " + transaction);
    }

    private boolean transactionLimitsIsExceeded(Account account, Transaction transaction) {
        return false;//
    }

    private void transferMoney(Account accountFrom, Account accountTo, Float sum) {

        accountFrom.setBalance(accountFrom.getBalance() - sum);
        accountTo.setBalance(accountTo.getBalance() + sum);

        accountRepository.save(accountFrom);
        accountRepository.save(accountTo);
    }
}
