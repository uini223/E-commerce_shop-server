package com.bookshop.bazydanych.platform;

import com.bookshop.bazydanych.location.PlatformLocation;
import com.bookshop.bazydanych.shared.BaseNamedEntity;
import com.bookshop.bazydanych.shop.Shop;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "platforms")
public class Platform extends BaseNamedEntity {

    @Column
    private String status;

    @Column(insertable = false)
    private Date creation_date;

    @ManyToOne
    private Shop shop;

    @OneToOne
    private PlatformLocation location;


    public Platform(String name, String status, Date creation_date, Shop shop) {
        super(name);
        this.status = status;
        this.creation_date = creation_date;
        this.shop = shop;
    }

    public Platform(){}

    public String getStatus() {
        return status;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public Shop getShop() {
        return shop;
    }

    public PlatformLocation getLocation() {
        return location;
    }
}
