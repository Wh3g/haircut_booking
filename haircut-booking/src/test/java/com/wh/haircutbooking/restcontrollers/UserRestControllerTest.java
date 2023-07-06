package com.wh.haircutbooking.restcontrollers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.wh.haircutbooking.entities.User;
import com.wh.haircutbooking.services.UserSevice;

@ExtendWith(MockitoExtension.class)
public class UserRestControllerTest {

	@InjectMocks
	private UserRestController controller;

	@Mock
	private UserSevice service;

	private User user = mock(User.class);

	@Test
	public void testCreateUser() {
		controller.createUser(user);

		verify(service, times(1)).createUser(user);
	}
}
