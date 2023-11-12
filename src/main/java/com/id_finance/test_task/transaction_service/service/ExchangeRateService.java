package com.id_finance.test_task.transaction_service.service;

import com.id_finance.test_task.transaction_service.entity.ExchangeRate;

import java.util.concurrent.ExecutionException;

public interface ExchangeRateService {

    ExchangeRate updateExchangeRate(String currency) throws ExecutionException, InterruptedException;
}
