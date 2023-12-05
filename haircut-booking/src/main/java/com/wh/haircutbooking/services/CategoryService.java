package com.wh.haircutbooking.services;

import java.util.List;

import com.wh.haircutbooking.entities.Category;

public interface CategoryService {

	public Category createCategory(Category category);

	public List<Category> getAllCategories();
}
