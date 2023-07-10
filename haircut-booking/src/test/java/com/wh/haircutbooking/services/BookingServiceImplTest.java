package com.wh.haircutbooking.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.wh.haircutbooking.entities.Booking;
import com.wh.haircutbooking.repositories.BookingRepository;

@ExtendWith(MockitoExtension.class)
public class BookingServiceImplTest {

	@InjectMocks
	private BookingServiceImpl service;

	@Mock
	private BookingRepository repository;

	private Booking booking = mock(Booking.class);

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
		service.getAllBookings();

		verify(repository, times(1)).findAll();
	}

}
