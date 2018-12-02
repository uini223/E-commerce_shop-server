package com.bookshop.bazydanych.category;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	private CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping("/all")
	public List<Category> getAllCategories() {
		return categoryService.getAllCategories();
	}

	@GetMapping("/{id}")
	public Category getCategory(@PathVariable Long id){
		return categoryService.getCategory(id);
	}

	@PostMapping("/add")
    public void addCategory(@RequestBody Category category){
	    categoryService.addCategory(category);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Long id){
	    categoryService.deleteCategory(id);
    }
}
