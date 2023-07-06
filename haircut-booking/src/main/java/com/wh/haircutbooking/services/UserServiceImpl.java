package com.wh.haircutbooking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wh.haircutbooking.entities.User;
import com.wh.haircutbooking.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserSevice {

	@Autowired
	private UserRepository repository;

	@Override
	public User createUser(User user) {
		return repository.save(user);
	}

	// @Override
	// public User getUser(String email, String password) {
	// // TODO Auto-generated method stub
	// throw new UnsupportedOperationException("Unimplemented method 'getUser'");
	// }

}
