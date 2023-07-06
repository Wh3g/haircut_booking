package com.wh.haircutbooking.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.wh.haircutbooking.entities.User;

@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {

	@Mock
	private UserRepository repository;

	private User user = mock(User.class);

	@Test
	public void testGetByEmailAndPassword() {

		when(repository.getByEmailAndPassword(user.getEmail(), user.getPassword())).thenReturn(Optional.of(user));
		Optional<User> actualResult = repository.getByEmailAndPassword(user.getEmail(), user.getPassword());

		assertEquals(Optional.of(user), actualResult);
	}
}
