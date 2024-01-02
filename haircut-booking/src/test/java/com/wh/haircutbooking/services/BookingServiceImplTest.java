package com.wh.haircutbooking.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.wh.haircutbooking.entities.Booking;
import com.wh.haircutbooking.entities.User;
import com.wh.haircutbooking.repositories.BookingRepository;

@ExtendWith(MockitoExtension.class)
public class BookingServiceImplTest {

	@InjectMocks
	private BookingServiceImpl service;

	@Mock
	private BookingRepository repository;

	@Mock
	private UserService userService;

	private Booking booking = mock(Booking.class);
	private User user = mock(User.class);

	@Test
	public void testCreateBooking() {
		service.createBooking(booking);

		verify(repository, times(1)).save(booking);
	}

	@Test
	public void testCreateBookingReturn() {
		when(repository.save(booking)).thenReturn(booking);

		Booking actualResult = service.createBooking(booking);

		assertNotNull(actualResult);
	}

	@Test
	public void testGetAllBookings() {
		when(user.isAdmin()).thenReturn(true);
		when(userService.getUser(user.getEmail(), user.getPassword())).thenReturn(Optional.of(user));
		service.getAllBookings(user.getEmail(), user.getPassword());

		verify(repository, times(1)).findAll();
	}

	@Test
	public void testGetAllBookingsReturn() {
		when(user.isAdmin()).thenReturn(true);
		when(userService.getUser(user.getEmail(), user.getPassword())).thenReturn(Optional.of(user));
		List<Booking> list = new ArrayList<>();
		list.add(mock(Booking.class));

		when(repository.findAll()).thenReturn(list);

		List<Booking> actualResult = service.getAllBookings(user.getEmail(), user.getPassword());

		assertEquals(list, actualResult);
	}

	@Test
	public void testNonAdminGetBookings() {
		when(user.isAdmin()).thenReturn(false);
		when(userService.getUser(user.getEmail(), user.getPassword())).thenReturn(Optional.of(user));

		User user2 = mock(User.class);
		when(booking.getUser()).thenReturn(user2, null);

		List<Booking> list = new ArrayList<>();
		list.add(booking);

		when(repository.findAll()).thenReturn(list);

		User actualResult = service.getAllBookings(user.getEmail(), user.getPassword())
									.get(0)
									.getUser();
		
		assertEquals(null, actualResult);
	}
}
