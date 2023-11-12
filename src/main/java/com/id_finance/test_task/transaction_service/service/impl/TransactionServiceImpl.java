package com.id_finance.test_task.transaction_service.service.impl;

import com.id_finance.test_task.transaction_service.dto.LimitExceededTransactionDto;
import com.id_finance.test_task.transaction_service.entity.Account;
import com.id_finance.test_task.transaction_service.entity.Transaction;
import com.id_finance.test_task.transaction_service.repository.TransactionRepository;
import com.id_finance.test_task.transaction_service.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<LimitExceededTransactionDto> getLimitExceededTransactions(Account account) {
        return transactionRepository.getLimitExceededTransactions(account);
    }

    @Override
    public void save(Transaction transaction) {
        transaction.setDateTime(ZonedDateTime.now());

//        Account accountFrom = accountRepository.findById(transaction.getAccountFrom().getId()).get();
//        Account accountTo = accountRepository.findById(transaction.getAccountTo().getId()).get();

//        System.out.println(accountFrom);

//        if (accountFrom.getBalance() < transaction.getSum()) {
//            transaction.setLimitExceeded(true);
//        }
//        transaction.getAccountFrom().setBalance(transaction.getAccountFrom().getBalance() - transaction.getSum());
//        transaction.getAccountTo().setBalance(transaction.getAccountTo().getBalance() + transaction.getSum());
        transactionRepository.save(transaction);
    }
}
