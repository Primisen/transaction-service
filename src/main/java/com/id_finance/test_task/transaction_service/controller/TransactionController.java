package com.id_finance.test_task.transaction_service.controller;

import com.id_finance.test_task.transaction_service.dto.LimitExceededTransactionDto;
import com.id_finance.test_task.transaction_service.dto.TransactionDto;
import com.id_finance.test_task.transaction_service.mapper.TransactionMapper;
import com.id_finance.test_task.transaction_service.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TransactionMapper transactionMapper;

    @Operation(summary = "Get limit exceeded transaction by account id")
    @GetMapping
    public List<LimitExceededTransactionDto> getLimitExceededTransactions(@RequestParam Integer accountId) {
        return transactionService.getLimitExceededTransactions(accountId);
    }

    @Operation(summary = "Save transaction")
    @PostMapping
    public void save(@RequestBody final TransactionDto transactionDto) {
        transactionService.save(transactionMapper.convertToEntity(transactionDto));
    }
}
