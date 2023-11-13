package com.id_finance.test_task.transaction_service.mapper;

import com.id_finance.test_task.transaction_service.dto.LimitDto;
import com.id_finance.test_task.transaction_service.entity.Limit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LimitMapper {

    @Mapping(target = "account.id", source = "accountId")
    Limit convertToEntity(LimitDto limitDto);
}
