package com.wh.haircutbooking.services;

import java.util.List;

import com.wh.haircutbooking.entities.Booking;

public interface BookingService {

	public Booking createBooking(Booking booking);

	public List<Booking> getAllBookings();
}
