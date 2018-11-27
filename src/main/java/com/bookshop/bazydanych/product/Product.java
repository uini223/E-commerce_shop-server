package com.bookshop.bazydanych.product;

import com.bookshop.bazydanych.category.Category;
import com.bookshop.bazydanych.currency.Currency;
import com.bookshop.bazydanych.shared.BaseNamedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product extends BaseNamedEntity {

    @Column
    private String unit;

    @Column
    private String producent;

    @Column
    private Integer stock;

    @Column
    private Double price;

    @Column
    private String description;

    @ManyToOne
    private Currency currency;

    @ManyToOne
    private Category category;

    public Product(String name, String unit, String producent, Integer stock, Double price, String description, Currency currency, Category category) {
        super(name);
        this.unit = unit;
        this.producent = producent;
        this.stock = stock;
        this.price = price;
        this.description = description;
        this.currency = currency;
        this.category = category;
    }

    public Product(){}

    public String getUnit() {
        return unit;
    }

    public String getProducent() {
        return producent;
    }

    public Integer getStock() {
        return stock;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Category getCategory() {
        return category;
    }
}
