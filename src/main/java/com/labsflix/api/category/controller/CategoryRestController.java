package com.labsflix.api.category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.labsflix.api.category.service.CategoryService;
import com.labsflix.api.domain.Category;

@RestController
@RequestMapping("/v1")
public class CategoryRestController {
	
	private CategoryService categoryService;

	@Autowired
	public CategoryRestController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping("/categories")
	public List<Category> getCategories() {
		return categoryService.getCategories();
	}

	@GetMapping("/categories/{id}")
	public Category getCategory(@PathVariable(value = "id") String id) {
		return categoryService.getCategory(id);
	}
}