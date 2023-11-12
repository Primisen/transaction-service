package com.id_finance.test_task.transaction_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "exchange_rate")
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter(AccessLevel.PUBLIC)
@Builder
@ToString
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Float rate;
    private Long timestamp;
    private String symbol;
}
