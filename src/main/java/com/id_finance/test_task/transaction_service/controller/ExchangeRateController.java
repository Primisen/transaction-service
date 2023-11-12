package com.id_finance.test_task.transaction_service.controller;

import com.id_finance.test_task.transaction_service.entity.ExchangeRate;
import com.id_finance.test_task.transaction_service.service.ExchangeRateService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/exchange-rate")
public class ExchangeRateController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @Operation(summary = "The currency pair you want to request. Slash(/) delimiter is used E.g. EUR/USD or BTC/ETH will be correct")
    @GetMapping
    public ExchangeRate getExchangeRate(@RequestParam String currency) throws ExecutionException, InterruptedException {
        return exchangeRateService.updateExchangeRate(currency);
    }
}
