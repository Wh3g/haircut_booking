package com.wh.haircutbooking.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;

import com.wh.haircutbooking.entities.Category;
import com.wh.haircutbooking.services.CategoryService;

public class CategoryRestController {

	@Autowired
	private CategoryService service;

	public void createCategory(Category category) {
		service.createCategory(category);
	}

}
