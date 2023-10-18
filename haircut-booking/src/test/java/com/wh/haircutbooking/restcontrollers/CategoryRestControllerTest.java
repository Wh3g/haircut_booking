package com.wh.haircutbooking.restcontrollers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.wh.haircutbooking.entities.Category;
import com.wh.haircutbooking.services.CategoryService;

@ExtendWith(MockitoExtension.class)
public class CategoryRestControllerTest {

	@InjectMocks
	private CategoryRestController controller;

	@Mock
	private CategoryService service;

	private Category category = mock(Category.class);

	private MockHttpServletRequest request = new MockHttpServletRequest();

	@BeforeEach
	public void setup() {
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	}

	@Test
	public void testCreateCategory() {
		controller.createCategory(category);

		verify(service, times(1)).createCategory(category);
	}

	@Test
	public void testCreateCategoryResponse() {
		ResponseEntity<Category> actualResult = controller.createCategory(category);

		assertEquals(HttpStatus.CREATED, actualResult.getStatusCode());
	}
}
