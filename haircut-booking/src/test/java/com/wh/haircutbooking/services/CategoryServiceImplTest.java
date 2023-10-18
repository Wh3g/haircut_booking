package com.wh.haircutbooking.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.wh.haircutbooking.entities.Category;
import com.wh.haircutbooking.repositories.CategoryRepository;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTest {

	@InjectMocks
	private CategoryServiceImpl service;

	@Mock
	private CategoryRepository repository;

	private Category category = mock(Category.class);

	@Test
	public void testCreateCategory() {
		service.createCategory(category);

		verify(repository, times(1)).save(category);
	}
}
