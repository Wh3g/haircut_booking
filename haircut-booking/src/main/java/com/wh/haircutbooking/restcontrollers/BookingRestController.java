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

	// the {email} and {password} in the request path are arguments in the method
	// below

	// the body of the post request will be
	// saved to a Booking object and
	// passed as an argument
	@PostMapping("/bookings")
	public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
		try {
			Booking storedBooking = service.createBooking(booking);
			return new ResponseEntity<Booking>(storedBooking, HttpStatus.CREATED); // confirms Booking has been saved
		} catch (IllegalStateException e) { // catches exception to return a different result
			System.out.println(e.getMessage());
			return new ResponseEntity<Booking>(booking, HttpStatus.CONFLICT); // confirms request has failed due to a
																				// conflict
		}
	}

	// the {email} and {password} in the request path are arguments in the method
	// below
	@GetMapping("/bookings/{email}/{password}")
	public List<Booking> getAllBookings(@PathVariable("email") String email,
			@PathVariable("password") String password) {
		return service.getAllBookings(email, password);
	}

}
