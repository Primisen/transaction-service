package com.id_finance.test_task.transaction_service.mapper;

import com.id_finance.test_task.transaction_service.dto.LimitExceededTransactionDto;
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

    @Mapping(target = "account_from", source = "transaction.accountFrom.id")
    @Mapping(target = "account_to", source = "transaction.accountTo.id")
    @Mapping(target = "currency_shortname", source = "transaction.currencyShortname")
    @Mapping(target = "expense_category", source = "transaction.expenseCategory")
    @Mapping(target = "limit_sum", source = "transaction.limitExceeded.sum")
    @Mapping(target = "limit_datetime", source = "transaction.limitExceeded.dateTime")
    @Mapping(target = "limit_currency_shortname", source = "transaction.limitExceeded.currencyShortname")
    LimitExceededTransactionDto convertToDto(Transaction transaction);
}
