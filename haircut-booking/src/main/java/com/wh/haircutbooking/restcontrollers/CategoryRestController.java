package com.wh.haircutbooking.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wh.haircutbooking.entities.Category;
import com.wh.haircutbooking.services.CategoryService;

public class CategoryRestController {

	@Autowired
	private CategoryService service;

	public ResponseEntity<Category> createCategory(Category category) {
		Category storedCategory = service.createCategory(category);

		return new ResponseEntity<Category>(storedCategory, HttpStatus.CREATED);
	}

}
