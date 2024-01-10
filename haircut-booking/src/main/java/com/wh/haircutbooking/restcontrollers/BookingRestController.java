package com.wh.haircutbooking.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		try {
			Booking storedBooking = service.createBooking(booking);
			return new ResponseEntity<Booking>(storedBooking, HttpStatus.CREATED);
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Booking>(booking, HttpStatus.CONFLICT);
		}
	}

	@GetMapping("/bookings/{email}/{password}")
	public List<Booking> getAllBookings(@PathVariable("email") String email,
			@PathVariable("password") String password) {
		return service.getAllBookings(email, password);
	}

}
