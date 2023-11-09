package com.id_finance.test_task.transaction_service.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
@Setter(AccessLevel.PUBLIC)
public class LimitExceededTransactionDto extends TransactionDto{

    private Float limit_sum;
    private LocalDateTime limit_datetime;
    private String limit_currency_shortname;
}
