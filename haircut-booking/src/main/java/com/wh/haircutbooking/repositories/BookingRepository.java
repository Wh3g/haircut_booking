package com.wh.haircutbooking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wh.haircutbooking.entities.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
	// no code needed as most CRUD functionality can be done with methods from
	// JpaRepository
}
