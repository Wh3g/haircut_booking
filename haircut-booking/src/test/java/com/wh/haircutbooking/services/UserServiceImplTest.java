package com.wh.haircutbooking.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.wh.haircutbooking.entities.User;
import com.wh.haircutbooking.repositories.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

	@InjectMocks
	private UserServiceImpl service;

	@Mock
	private UserRepository repository;

	private User user = mock(User.class);

	@Test
	public void testCreateUser() {
		service.createUser(user);

		verify(repository, times(1)).save(user);
	}

	@Test
	public void testGetUser() {
		service.getUser(user.getEmail(), user.getPassword());

		verify(repository, times(1)).getByEmailAndPassword(user.getEmail(), user.getPassword());
	}
}
