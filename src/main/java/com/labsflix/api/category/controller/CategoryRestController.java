package com.labsflix.api.category.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.labsflix.api.category.service.CategoryService;
import com.labsflix.api.category.vo.Category;

@RestController
@RequestMapping("/v1")
public class CategoryRestController {
	
	private static Logger logger = LoggerFactory.getLogger(CategoryRestController.class);

	private CategoryService categoryService;

	@Autowired
	public CategoryRestController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping("/categories")
	public List<Category> getCategories() {
		logger.debug("getCategories() called!!");
		return categoryService.getCategories();
	}

	@GetMapping("/categories/{id}")
	public Category getCategory(@PathVariable(value = "id") String id) {
		logger.debug("getCategory() called!!");
		return categoryService.getCategory(id);
	}
}