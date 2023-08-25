package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.dto.BookingsDTO;
import com.app.dto.FlightsDTO;
import com.app.entities.Bookings;
import com.app.entities.User;

public interface BookingsService {
	
	 String addBookings(List<BookingsDTO> bookings);
	
	//List<BookingsDTO> getBookings(Long userId);
	
}
