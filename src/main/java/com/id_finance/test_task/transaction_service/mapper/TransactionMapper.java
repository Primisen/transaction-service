package com.id_finance.test_task.transaction_service.mapper;

import com.id_finance.test_task.transaction_service.dto.TransactionDto;
import com.id_finance.test_task.transaction_service.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    @Mapping(target = "accountFrom.id", source = "account_from")
    @Mapping(target = "accountTo.id", source = "account_to")
    @Mapping(target = "currencyShortname", source = "currency_shortname")
    @Mapping(target = "expenseCategory", source = "expense_category")
    Transaction convertToEntity(TransactionDto transactionDto);
}
