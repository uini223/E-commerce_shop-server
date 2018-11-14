package com.bookshop.bazydanych.product;

import com.bookshop.bazydanych.shared.BaseNamedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
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

    public Product(long id, String name, String unit, String producent, Integer stock, Double price, String description) {
        super(id, name);
        this.unit = unit;
        this.producent = producent;
        this.stock = stock;
        this.price = price;
        this.description = description;
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
}
