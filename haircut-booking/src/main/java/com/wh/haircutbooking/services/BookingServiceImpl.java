package com.wh.haircutbooking.services;

import com.wh.haircutbooking.entities.Booking;
import com.wh.haircutbooking.repositories.BookingRepository;

public class BookingServiceImpl implements BookingService {

	private BookingRepository repository;

	@Override
	public Booking createBooking(Booking booking) {
		return repository.save(booking);
	}

}
