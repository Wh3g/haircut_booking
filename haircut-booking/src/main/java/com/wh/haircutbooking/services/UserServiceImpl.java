package com.wh.haircutbooking.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.wh.haircutbooking.entities.User;
import com.wh.haircutbooking.repositories.UserRepository;

public class UserServiceImpl implements UserSevice {

	@Autowired
	private UserRepository repository;

	@Override
	public User createUser(User user) {
		return repository.save(user);
	}

}
