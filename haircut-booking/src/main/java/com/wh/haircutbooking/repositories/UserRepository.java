package com.wh.haircutbooking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wh.haircutbooking.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
