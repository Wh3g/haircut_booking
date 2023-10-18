package com.wh.haircutbooking.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.wh.haircutbooking.entities.Category;
import com.wh.haircutbooking.repositories.CategoryRepository;

public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository repository;

	@Override
	public Category createCategory(Category category) {
		return repository.save(category);
	}

}