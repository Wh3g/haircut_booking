package com.wh.haircutbooking.restcontrollers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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
import com.wh.haircutbooking.entities.User;
import com.wh.haircutbooking.services.CategoryService;

@ExtendWith(MockitoExtension.class)
public class CategoryRestControllerTest {

	@InjectMocks
	private CategoryRestController controller;

	@Mock
	private CategoryService service;

	private Category category = mock(Category.class);
	private User user = mock(User.class);

	private MockHttpServletRequest request = new MockHttpServletRequest();

	@BeforeEach
	public void setup() {
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	}

	@Test
	public void testCreateCategory() {
		controller.createCategory(category, user.getEmail(), user.getPassword());

		verify(service, times(1)).createCategory(category, user.getEmail(), user.getPassword());
	}

	@Test
	public void testCreateCategoryResponse() {
		ResponseEntity<Category> actualResult = controller.createCategory(category, user.getEmail(),
				user.getPassword());

		assertEquals(HttpStatus.CREATED, actualResult.getStatusCode());
	}

	@Test
	public void testGetAllCategories() {
		controller.getAllCategories();

		verify(service, times(1)).getAllCategories();
	}

	@Test
	public void testGetAllCategoriesResponse() {
		List<Category> list = new ArrayList<>();
		list.add(mock(Category.class));

		when(service.getAllCategories()).thenReturn(list);

		List<Category> actualResult = controller.getAllCategories();

		assertEquals(list, actualResult);
	}
}
