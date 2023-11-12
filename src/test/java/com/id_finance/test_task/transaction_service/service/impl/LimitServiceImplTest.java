package com.id_finance.test_task.transaction_service.service.impl;

import com.id_finance.test_task.transaction_service.entity.CurrencyShortname;
import com.id_finance.test_task.transaction_service.entity.Account;
import com.id_finance.test_task.transaction_service.entity.ExpenseCategory;
import com.id_finance.test_task.transaction_service.entity.Limit;
import com.id_finance.test_task.transaction_service.repository.LimitRepository;
import com.id_finance.test_task.transaction_service.service.LimitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class LimitServiceImplTest {

    private LimitService limitService;

    @BeforeEach
    void init(@Mock LimitRepository mockedLimitRepository) {
        limitService = new LimitServiceImpl(mockedLimitRepository);
    }

    @Test
    void givenNewLimit_whenSavingLimit_thenCurrencyShortnameIsUSD() {

        Limit newLimit = Limit.builder()
                .account(Account.builder()
                        .id(1)
                        .build())
                .sum(1000.0F)
                .expenseCategory(ExpenseCategory.PRODUCT)
                .build();

        limitService.save(newLimit);

        String actualCurrencyShortname = newLimit.getCurrencyShortname().name();
        String expectedCurrencyShortname = CurrencyShortname.USD.name();

        assertEquals(expectedCurrencyShortname, actualCurrencyShortname);
    }

}
