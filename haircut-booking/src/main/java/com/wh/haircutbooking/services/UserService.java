package com.wh.haircutbooking.services;

import java.util.Optional;

import com.wh.haircutbooking.entities.User;

public interface UserService {

	public User createUser(User user);

	public Optional<User> getUser(String email, String password);
}
