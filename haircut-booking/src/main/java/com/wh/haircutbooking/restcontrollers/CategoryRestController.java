package com.wh.haircutbooking.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wh.haircutbooking.entities.Category;
import com.wh.haircutbooking.services.CategoryService;

@RestController
public class CategoryRestController {

	@Autowired
	private CategoryService service;

	@PostMapping("/categories")
	public ResponseEntity<Category> createCategory(@RequestBody Category category) {
		Category storedCategory = service.createCategory(category);

		return new ResponseEntity<Category>(storedCategory, HttpStatus.CREATED);
	}

	@GetMapping("/categories")
	public List<Category> getAllCategories() {
		return service.getAllCategories();
	}

}
