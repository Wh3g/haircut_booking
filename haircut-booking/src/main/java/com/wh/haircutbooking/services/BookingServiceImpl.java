package com.wh.haircutbooking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wh.haircutbooking.entities.Booking;
import com.wh.haircutbooking.repositories.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository repository;

	@Override
	public Booking createBooking(Booking booking) {
		return repository.save(booking);
	}

	@Override
	public List<Booking> getAllBookings() {
		return repository.findAll();
	}

}
