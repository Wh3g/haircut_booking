package com.wh.haircutbooking.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wh.haircutbooking.entities.Booking;
import com.wh.haircutbooking.services.BookingService;

@RestController
public class BookingRestController {

	@Autowired
	private BookingService service;

	@PostMapping("/bookings")
	public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
		Booking storedBooking = service.createBooking(booking);
		return new ResponseEntity<Booking>(storedBooking, HttpStatus.CREATED);
	}

}
