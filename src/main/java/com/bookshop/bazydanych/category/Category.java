package com.bookshop.bazydanych.category;

import com.bookshop.bazydanych.shared.BaseNamedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category extends BaseNamedEntity {

	@Column
	private String description;

	public Category() {
	}

	public String getDescription() {
		return description;
	}
}
