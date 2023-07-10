package com.wh.haircutbooking.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.wh.haircutbooking.entities.Booking;
import com.wh.haircutbooking.services.BookingService;

@RestController
public class BookingRestController {

	@Autowired
	private BookingService service;

	public void createBooking(Booking booking) {
		service.createBooking(booking);
	}

}
