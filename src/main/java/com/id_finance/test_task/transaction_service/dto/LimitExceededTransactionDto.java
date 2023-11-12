package com.id_finance.test_task.transaction_service.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter(AccessLevel.PUBLIC)
public class LimitExceededTransactionDto extends TransactionDto{

    private Float limit_sum;
    private ZonedDateTime limit_datetime;
    private String limit_currency_shortname;
}
