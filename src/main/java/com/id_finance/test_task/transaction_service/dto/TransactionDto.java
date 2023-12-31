package com.id_finance.test_task.transaction_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(
            type = "integer",
            example = "1")
    private Integer account_from;
    @Schema(
            type = "integer",
            example = "2")
    private Integer account_to;
    @Schema(
            type = "string",
            example = "USD")
    private String currency_shortname;
    @Schema(
            type = "float",
            example = "12.50")
    private Float sum;
    @Schema(
            type = "string",
            example = "SERVICE")
    private String expense_category;
}
