package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.BookingsDTO;
import com.app.dto.FlightsDTO;
import com.app.entities.Bookings;
import com.app.entities.Flights;
import com.app.entities.User;
import com.app.repository.BookingRepository;
import com.app.repository.FlightsRepository;
import com.app.repository.UserRepository;


@Service
@Transactional
public class BookingsServiceImpl implements BookingsService {

	@Autowired
	private BookingRepository bookingDao;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private FlightsRepository flightRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public String addBooking(BookingsDTO booking) {
		Bookings bookingQuery=mapper.map(booking, Bookings.class);
		User user = userRepo.findById(booking.getUserId()).orElse(null);
		Flights flight =flightRepo.findByFlightSrNo(booking.getFlightSrNo());
		bookingQuery.setUserId(user);
		bookingQuery.setFlightSrNo(flight);
		bookingDao.save(bookingQuery);
		return "booking done successfully...";
	}

	@Override
	public List<BookingsDTO> getBookings(Long userId) {
		
		//User user = userRepo.findByUserId(userId);
		
		List<Bookings> bookingList=bookingDao.myBookings(userId);
		
		return bookingList.stream()
				.map(book->mapper.map(book, BookingsDTO.class))
				.collect(Collectors.toList());
	}

	
		
	}

	
	
	
	


