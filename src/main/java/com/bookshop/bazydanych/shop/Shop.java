package com.bookshop.bazydanych.shop;

import com.bookshop.bazydanych.shared.BaseNamedEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "shops")
public class Shop extends BaseNamedEntity {

	@Column
	private String ownerName;

	@Column(insertable = false)
	@Temporal(TemporalType.DATE)
	private Date creationDate;

	public Shop(long id, String name, String ownerName) {
		super(id, name);
		this.ownerName = ownerName;
		this.creationDate = new Date();
	}

	public Shop() {
	}

	public String getOwnerName() {
		return ownerName;
	}

	public Date getCreationDate() {
		return creationDate;
	}
}
