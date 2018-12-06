package com.bookshop.bazydanych.product;

import com.bookshop.bazydanych.category.Category;
import com.bookshop.bazydanych.currency.Currency;
import com.bookshop.bazydanych.platform.Platform;
import com.bookshop.bazydanych.shared.BaseNamedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="products")
public class Product extends BaseNamedEntity implements Serializable {

    @Column
    private String unit;

    @Column
    private String producent;

    @Column
    private Integer stock;

    @Column
    private Double price;

    @Column
    private String status;

    @Column
    private String description;

    @ManyToOne
    private Currency currency;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Platform platform;

    public Product(String name, String unit, String producent, Integer stock, Double price, String status, String description, Currency currency, Category category, Platform platform) {
        super(name);
        this.unit = unit;
        this.producent = producent;
        this.stock = stock;
        this.price = price;
        this.status = status;
        this.description = description;
        this.currency = currency;
        this.category = category;
        this.platform = platform;
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

    public String getStatus() {
        return status;
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

    public Platform getPlatform() {
        return platform;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
