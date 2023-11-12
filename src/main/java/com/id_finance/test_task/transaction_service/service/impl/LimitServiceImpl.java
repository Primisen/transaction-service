package com.id_finance.test_task.transaction_service.service.impl;

import com.id_finance.test_task.transaction_service.entity.CurrencyShortname;
import com.id_finance.test_task.transaction_service.entity.Limit;
import com.id_finance.test_task.transaction_service.repository.LimitRepository;
import com.id_finance.test_task.transaction_service.service.LimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LimitServiceImpl implements LimitService {

    private final LimitRepository limitRepository;

    @Autowired
    LimitServiceImpl(LimitRepository limitRepository) {
        this.limitRepository = limitRepository;
    }

    @Override
    public void save(Limit limit) {
        limit.setDateTime(LocalDateTime.now());
        limit.setCurrencyShortname(CurrencyShortname.USD);
        limitRepository.save(limit);
    }
}
