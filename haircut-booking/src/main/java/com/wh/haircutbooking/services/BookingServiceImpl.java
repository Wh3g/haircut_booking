package com.wh.haircutbooking.services;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wh.haircutbooking.entities.Booking;
import com.wh.haircutbooking.entities.User;
import com.wh.haircutbooking.repositories.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository repository;

	@Autowired
	private UserService userService;

	@Override
	public Booking createBooking(Booking booking) {
		return repository.save(booking);
	}

	@Override
	public List<Booking> getAllBookings(String email, String password) {
		User user = userService.getUser(email, password).get();

		if (user.isAdmin()) {
			return repository.findAll();
		} else {
			return privacyFilter(repository.findAll(), user);
		}
	}

	private List<Booking> privacyFilter(List<Booking> bookings, User user) {
		Predicate<Booking> otherUser = booking -> booking.getUser() != user;
		Function<Booking, Booking> anonymousBooking = booking -> new Booking(booking.getId(), booking.getTimeStart(),
				booking.getCategory());
		return bookings.stream()
				.filter(otherUser)
				.map(anonymousBooking)
				.collect(Collectors.toList());
	}
}
