package com.wh.haircutbooking.services;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.wh.haircutbooking.entities.Category;
import com.wh.haircutbooking.entities.User;
import com.wh.haircutbooking.repositories.CategoryRepository;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTest {

	@InjectMocks
	private CategoryServiceImpl service;

	@Mock
	private CategoryRepository repository;

	@Mock
	private UserService userService;

	private Category category = mock(Category.class);
	private User user = mock(User.class);

	@Test
	public void testCreateCategory() {
		when(user.isAdmin()).thenReturn(true);
		when(userService.getUser(user.getEmail(), user.getPassword())).thenReturn(Optional.of(user));
		try {
			service.createCategory(category, user.getEmail(), user.getPassword());
		} catch (RuntimeException e) {
			System.out.println(e);
		}

		verify(repository, times(1)).save(category);
	}

	@Test
	public void testNonAdminUser() {
		when(user.isAdmin()).thenReturn(false);
		when(userService.getUser(user.getEmail(), user.getPassword())).thenReturn(Optional.of(user));

		assertThrows(RuntimeException.class,
				() -> service.createCategory(category, user.getEmail(), user.getPassword()));
	}

	@Test
	public void testGetCategories() {
		service.getAllCategories();

		verify(repository, times(1)).findAll();
	}
}
