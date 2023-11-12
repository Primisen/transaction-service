package com.id_finance.test_task.transaction_service.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter(AccessLevel.PUBLIC)
public class TransactionDto {

    private Integer account_from;
    private Integer account_to;
    private String currency_shortname;
    private Float sum;
    private String expense_category;
}
