package com.wh.haircutbooking.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wh.haircutbooking.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	// minimal code needed as most CRUD functionality can be done with methods from
	// JpaRepository

	// below is a custom query to find a specific record in the user table using
	// email and password, this allows for Login functionality

	@Query("SELECT u FROM User u WHERE email = :email AND password = :password")
	Optional<User> getByEmailAndPassword(@Param("email") String email, @Param("password") String password);

}
