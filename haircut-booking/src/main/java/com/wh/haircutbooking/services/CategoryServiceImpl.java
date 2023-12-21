package com.wh.haircutbooking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wh.haircutbooking.entities.Category;
import com.wh.haircutbooking.entities.User;
import com.wh.haircutbooking.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository repository;

	@Autowired
	private UserService userService;

	@Override
	public Category createCategory(Category category, String username, String password) throws RuntimeException {
		User user = userService.getUser(username, password).get();

		if (user.isAdmin()) {
			return repository.save(category);
		} else {
			throw new RuntimeException("This User does not have Admin privileges");
		}

	}

	@Override
	public List<Category> getAllCategories() {
		return repository.findAll();
	}

}
