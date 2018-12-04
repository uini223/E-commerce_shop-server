package com.bookshop.bazydanych.product;

import java.io.Serializable;

public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 4603576581112999592L;

	private Long id;
    private String name;
    private String producent;
    private String unit;
    private Integer stock;
    private String status;
    private Double price;
    private String description;
    private Long currency_id;
    private Long platform_id;
    private Long category_id;

    public ProductDTO(Long id, String name, String unit, String producent, Integer stock, String status, Double price, String description, Long currency_id, Long platform_id, Long category_id) {
        this.id = id;
        this.name = name;
        this.producent = producent;
        this.unit = unit;
        this.stock = stock;
        this.status = status;
        this.price = price;
        this.description = description;
        this.currency_id = currency_id;
        this.platform_id = platform_id;
        this.category_id = category_id;
    }

    public ProductDTO(){}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProducent() {
        return producent;
    }

    public Integer getStock() {
        return stock;
    }

    public String getStatus() {
        return status;
    }

    public Double getPrice() {
        return price;
    }

    public String getUnit() {
        return unit;
    }

    public String getDescription() {
        return description;
    }

    public Long getCurrency_id() {
        return currency_id;
    }

    public Long getPlatform_id() {
        return platform_id;
    }

    public Long getCategory_id() {
        return category_id;
    }
}
