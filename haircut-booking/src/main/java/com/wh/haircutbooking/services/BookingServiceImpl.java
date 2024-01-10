package com.wh.haircutbooking.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;
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
	public Booking createBooking(Booking booking) throws IllegalStateException {

		List<Booking> savedBookings = repository.findAll();
		LocalDateTime bookingEndTime = booking.getTimeStart().plusMinutes(booking.getCategory().getTime());

		for (Booking savedBooking : savedBookings) {
			if (checkOverlap(booking.getTimeStart(), bookingEndTime, savedBooking)) {
				continue;
			} else {
				throw new IllegalStateException("Booking overlaps with an existing booking");
			}
		}

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
		User nullUser = null;
		Function<Booking, Booking> anonymousBooking = booking -> {
			if (!booking.getUser().equals(user)) {
				booking.setUser(nullUser);
			}
			return booking;
		};
		List<Booking> filteredBookings = bookings
				.stream()
				.map(anonymousBooking)
				.collect(Collectors.toList());

		return filteredBookings;
	}

	private boolean checkOverlap(LocalDateTime startTime, LocalDateTime endTime, Booking booking) {
		LocalDateTime bookingEndTime = booking.getTimeStart().plusMinutes(booking.getCategory().getTime());
		if (startTime.isAfter(bookingEndTime) || endTime.isBefore(booking.getTimeStart())) {
			return true;
		} else {
			return false;
		}
	}
}
