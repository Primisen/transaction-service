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
public class LimitDto {

    @Schema(
            type = "integer",
            example = "1")
    private Integer accountId;
    @Schema(
            type = "float",
            example = "12.55")
    private Float sum;
    @Schema(
            type = "string",
            example = "PRODUCT")
    private String expenseCategory;
}
