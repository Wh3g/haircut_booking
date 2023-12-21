package com.wh.haircutbooking.restcontrollers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wh.haircutbooking.entities.User;
import com.wh.haircutbooking.services.UserService;

@RestController
public class UserRestController {

	@Autowired
	private UserService service;

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User storedUser = service.createUser(user);
		return new ResponseEntity<User>(storedUser, HttpStatus.CREATED);
	}

	@GetMapping("/users/{email}/{password}")
	public Optional<User> getUser(@PathVariable("email") String email, @PathVariable("password") String password) {
		return service.getUser(email, password);
	}

}
