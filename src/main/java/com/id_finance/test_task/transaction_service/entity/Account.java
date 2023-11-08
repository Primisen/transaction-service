package com.id_finance.test_task.transaction_service.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "account")
@RequiredArgsConstructor
@Getter
@Setter(AccessLevel.PUBLIC)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer number;
    private BigDecimal balance;

    @Enumerated(EnumType.ORDINAL)
    private CurrencyShortname currencyShortname;

    @OneToMany(mappedBy = "account", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Limit> limits;
}
