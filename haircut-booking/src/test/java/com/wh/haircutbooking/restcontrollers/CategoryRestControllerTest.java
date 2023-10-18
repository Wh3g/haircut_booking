package com.wh.haircutbooking.restcontrollers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.wh.haircutbooking.entities.Category;
import com.wh.haircutbooking.services.CategoryService;

@ExtendWith(MockitoExtension.class)
public class CategoryRestControllerTest {

	@InjectMocks
	private CategoryRestController controller;

	@Mock
	private CategoryService service;

	private Category category = mock(Category.class);

	@Test
	public void testCreateCategory() {
		controller.createCategory(category);

		verify(service, times(1)).createCategory(category);
	}
}
