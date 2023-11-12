package com.id_finance.test_task.transaction_service.service.impl;

import com.id_finance.test_task.transaction_service.entity.ExchangeRate;
import com.id_finance.test_task.transaction_service.repository.ExchangeRateRepository;
import com.id_finance.test_task.transaction_service.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.ExecutionException;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private final ExchangeRateRepository exchangeRateRepository;

    private static final String API_BASE_URL = "https://api.twelvedata.com";
    private static final String API_EXCHANGE_RATE_PATH = "/exchange_rate";
    private static final String API_EXCHANGE_RATE_QUERY_PARAM = "symbol";
    private static final String API_KEY = "2ebe7a02cccd47f5a0d0e0efbf737053";

    @Autowired
    ExchangeRateServiceImpl(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    @Override
    public ExchangeRate updateExchangeRate(String currency) throws ExecutionException, InterruptedException {

        WebClient webClient = WebClient.builder()
                .baseUrl(API_BASE_URL)
                .defaultHeader("Authorization", "apikey " + API_KEY)
                .build();

        ExchangeRate exchangeRate = webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(API_EXCHANGE_RATE_PATH)
                        .queryParam(API_EXCHANGE_RATE_QUERY_PARAM, currency)
                        .build())
                .retrieve()
                .bodyToMono(ExchangeRate.class)
                .block();

        exchangeRateRepository.save(exchangeRate);

        return exchangeRate;
    }
}
