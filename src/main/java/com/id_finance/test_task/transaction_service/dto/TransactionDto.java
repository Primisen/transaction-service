package com.id_finance.test_task.transaction_service.dto;

import java.time.LocalDateTime;

public class TransactionDto {

    private Integer account_from;
    private Integer account_to;
    private String currency_shortname;
    private Float sum;
    private String expense_category;
    private LocalDateTime datetime;
}
