package com.labsflix.api.category.service;

import java.util.List;

import com.labsflix.api.category.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labsflix.api.domain.Category;

@Service("categoryService")
public class CategoryService {

	private CategoryMapper categoryMapper;

	@Autowired
	public CategoryService(CategoryMapper categoryMapper) {
		this.categoryMapper = categoryMapper;
	}

	public List<Category> getCategories() {
		return categoryMapper.findAll();
	}

	public Category getCategory(String id) {
		return categoryMapper.findById(id);
	}

}