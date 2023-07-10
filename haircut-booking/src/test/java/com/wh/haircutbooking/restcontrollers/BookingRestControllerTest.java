package com.wh.haircutbooking.restcontrollers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.wh.haircutbooking.entities.Booking;
import com.wh.haircutbooking.services.BookingService;

@ExtendWith(MockitoExtension.class)
public class BookingRestControllerTest {

	@InjectMocks
	private BookingRestController controller;

	@Mock
	private BookingService service;

	private Booking booking = mock(Booking.class);

	@Test
	public void testCreateBooking() {
		controller.createBooking(booking);

		verify(service, times(1)).createBooking(booking);
	}
}
