package com.wh.haircutbooking.restcontrollers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

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

import com.wh.haircutbooking.entities.User;
import com.wh.haircutbooking.services.UserService;

@ExtendWith(MockitoExtension.class)
public class UserRestControllerTest {

	@InjectMocks
	private UserRestController controller;

	@Mock
	private UserService service;

	private User user = mock(User.class);

	private MockHttpServletRequest request = new MockHttpServletRequest();

	@BeforeEach
	public void setup() {
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	}

	@Test
	public void testCreateUser() {
		controller.createUser(user);

		verify(service, times(1)).createUser(user);
	}

	@Test
	public void testCreateUserResponse() {
		when(service.createUser(user)).thenReturn(user);

		ResponseEntity<User> actualResult = controller.createUser(user);

		assertEquals(HttpStatus.CREATED, actualResult.getStatusCode());
	}

	@Test
	public void testGetUser() {
		controller.getUser(user.getEmail(), user.getPassword());

		verify(service, times(1)).getUser(user.getEmail(), user.getPassword());
	}

	@Test
	public void testGetUserResponse() {
		when(service.getUser(user.getEmail(), user.getPassword())).thenReturn(Optional.of(user));

		Optional<User> actualResult = controller.getUser(user.getEmail(), user.getPassword());

		assertEquals(Optional.of(user), actualResult);
	}
}
