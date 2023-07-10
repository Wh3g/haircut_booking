package com.wh.haircutbooking.restcontrollers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.wh.haircutbooking.entities.Booking;
import com.wh.haircutbooking.services.BookingService;

@ExtendWith(MockitoExtension.class)
public class BookingRestControllerTest {

	@InjectMocks
	private BookingRestController controller;

	@Mock
	private BookingService service;

	private Booking booking = mock(Booking.class);

	private MockHttpServletRequest request = new MockHttpServletRequest();

	@BeforeEach
	public void setup() {
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	}

	@Test
	public void testCreateBooking() {
		controller.createBooking(booking);

		verify(service, times(1)).createBooking(booking);
	}

	@Test
	public void testCreateBookingResponse() {
		ResponseEntity<Booking> actualResult = controller.createBooking(booking);

		assertEquals(HttpStatus.CREATED, actualResult.getStatusCode());
	}

	@Test
	public void testGetAllBookings() {
		controller.getAllBookings();

		verify(service, times(1)).getAllBookings();
	}

	@Test
	public void testGetAllBookingsResponse() {
		List<Booking> list = new ArrayList<>();
		list.add(mock(Booking.class));

		when(service.getAllBookings()).thenReturn(list);

		List<Booking> actualResult = controller.getAllBookings();

		assertEquals(list, actualResult);
	}
}
