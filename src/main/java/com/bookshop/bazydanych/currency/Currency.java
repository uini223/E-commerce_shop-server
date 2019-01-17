package com.bookshop.bazydanych.currency;

import com.bookshop.bazydanych.shared.BaseNamedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="currencies")
public class Currency extends BaseNamedEntity {

    @Column
    private String code;

    @Column
    private Double exchange_rate;

    public Currency(String name, String code, Double exchange_rate) {
        super(name);
        this.code = code;
        this.exchange_rate = exchange_rate;
    }

    public Currency(){}

    public String getCode() {
        return code;
    }

    public Double getExchange_rate() {
        return exchange_rate;
    }
}
