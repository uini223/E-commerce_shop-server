package com.bookshop.bazydanych.category;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

	private CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	public Category getCategory(Long id){
		return categoryRepository.findById(id).get();
	}
}
