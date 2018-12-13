package com.bookshop.bazydanych.category;

import com.bookshop.bazydanych.product.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

	private CategoryRepository categoryRepository;
	private ProductRepository productRepository;

	public CategoryService(CategoryRepository categoryRepository, ProductRepository productRepository) {
		this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	public Category getCategory(Long id){
		return categoryRepository.findById(id).get();
	}

	public void addCategory(Category category){
		categoryRepository.save(category);
	}

	public void deleteCategory(Long id){
		if(productRepository.getAllByCategoryId(id).isEmpty()){
			categoryRepository.deleteById(id);
		} else {
			throw new RuntimeException("Category is in use!");
		}

	}

}
