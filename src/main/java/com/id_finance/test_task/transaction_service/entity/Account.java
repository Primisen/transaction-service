package com.id_finance.test_task.transaction_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "account")
@RequiredArgsConstructor
@Getter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PUBLIC)
    private Integer id;

    @Setter(AccessLevel.PUBLIC)
    private Float balance;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency_shortname")
    private CurrencyShortname currencyShortname;

    @Setter(AccessLevel.PUBLIC)
    @OneToMany(mappedBy = "account")
    private Set<Limit> limits;
}
