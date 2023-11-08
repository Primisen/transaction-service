package com.id_finance.test_task.transaction_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
@RequiredArgsConstructor
@Getter
@Setter(AccessLevel.PUBLIC)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "account_from")
    private Account accountFrom;

    @ManyToOne
    @JoinColumn(name = "account_to")
    private Account accountTo;

    @Enumerated(EnumType.ORDINAL)
    private CurrencyShortname currencyShortname;

    @Column(name = "limit_exceeded")
    protected Boolean limitExceeded;

    private BigDecimal sum;

    @Column(name = "datetime")
    private LocalDateTime dateTime;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseCategory expenseCategory;
}
