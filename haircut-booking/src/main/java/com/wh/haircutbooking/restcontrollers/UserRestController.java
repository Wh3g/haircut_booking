package com.wh.haircutbooking.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.wh.haircutbooking.entities.User;
import com.wh.haircutbooking.services.UserSevice;

@RestController
public class UserRestController {

	@Autowired
	private UserSevice service;

	public void createUser(User user) {
		service.createUser(user);
	}

}
