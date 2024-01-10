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
		// checkList method returns false if the booking overlaps with another booking
		if (checkList(booking)) {
			return repository.save(booking);
		} else { // throws exception
			throw new IllegalStateException("Booking overlaps with an existing booking");
		}

	}

	@Override
	public List<Booking> getAllBookings(String email, String password) {
		User user = userService.getUser(email, password).get();

		// if user is admin, they can see all the booking information
		if (user.isAdmin()) {
			return repository.findAll();
		} else { // if not, all user info is hidden, unless they are the sane user
			return privacyFilter(repository.findAll(), user);
		}
	}

	private List<Booking> privacyFilter(List<Booking> bookings, User user) {
		User nullUser = null;
		// Lambda expression saved to variable
		Function<Booking, Booking> anonymousBooking = booking -> {
			if (!booking.getUser().equals(user)) { // any bookings with a different user
				booking.setUser(nullUser); // the user field is set to null
			}
			return booking;
		};
		List<Booking> filteredBookings = bookings
				.stream() // iterates through bookings list
				.map(anonymousBooking) // runs anonymousBooking, changing certain elements
				.collect(Collectors.toList()); // saved as a new List

		return filteredBookings;
	}

	private boolean checkList(Booking booking) {
		List<Booking> savedBookings = repository.findAll(); // gets all saved bookings

		for (Booking savedBooking : savedBookings) { // iterates through savedBookings
			if (checkOverlap(booking.getTimeStart(), getBookingEndTime(booking), savedBooking)) {
				continue; // in booking doesn't overlap, continue
			} else {
				return false; // booking overlaps, cannot be saved
			}
		}
		return true;
	}

	private LocalDateTime getBookingEndTime(Booking booking) {
		return booking.getTimeStart().plusMinutes(booking.getCategory().getTime());
	}

	// checks booking to be saved against one saved booking
	private boolean checkOverlap(LocalDateTime startTime, LocalDateTime endTime, Booking booking) {
		if (startTime.isAfter(getBookingEndTime(booking)) || endTime.isBefore(booking.getTimeStart())) {
			return true; // booking doesn't overlap
		} else {
			return false; // booking does overlap
		}
	}
}
