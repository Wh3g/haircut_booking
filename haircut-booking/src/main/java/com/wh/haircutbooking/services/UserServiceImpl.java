package com.wh.haircutbooking.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wh.haircutbooking.entities.User;
import com.wh.haircutbooking.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public User createUser(User user) {
		return repository.save(user);
	}

	@Override
	public Optional<User> getUser(String email, String password) {
		return repository.getByEmailAndPassword(email, password);
	}

}
