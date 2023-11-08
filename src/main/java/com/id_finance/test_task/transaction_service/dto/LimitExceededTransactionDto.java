package com.id_finance.test_task.transaction_service.dto;

import java.time.LocalDateTime;

public class LimitExceededTransactionDto extends TransactionDto{

    private Float limit_sum;
    private LocalDateTime limit_datetime;
    private String limit_currency_shortname;
}
