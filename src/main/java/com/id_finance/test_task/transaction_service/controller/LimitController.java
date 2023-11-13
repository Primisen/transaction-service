package com.id_finance.test_task.transaction_service.controller;

import com.id_finance.test_task.transaction_service.dto.LimitDto;
import com.id_finance.test_task.transaction_service.mapper.LimitMapper;
import com.id_finance.test_task.transaction_service.service.LimitService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/limits")
public class LimitController {

    @Autowired
    private LimitService limitService;

    @Autowired
    private LimitMapper limitMapper;

    @Operation(summary = "Create new limit for account, in USD")
    @PostMapping
    public void save(@RequestBody LimitDto limitDto) {
        limitService.save(limitMapper.convertToEntity(limitDto));
    }
}
