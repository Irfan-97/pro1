package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.BookingsDTO;
import com.app.dto.FlightsDTO;
import com.app.dto.SignInRequestDTO;
import com.app.dto.UserDTO;
import com.app.entities.Bookings;
import com.app.service.BookingsService;
import com.app.service.UserService;

import lombok.Getter;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookingsService bookingService;
	
	@PostMapping("/register")
	public ResponseEntity<?> addNewUser(@RequestBody @Valid UserDTO dto){
		System.out.println("adding new user...");
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addNewUser(dto));
	}
	
	
	
	
	@PostMapping("/bookticket")
	public ResponseEntity<?> bookTicket(@RequestBody @Valid List<BookingsDTO> dto){
		System.out.println("booking ticket...");
		return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.addBookings(dto));
		
	}
	
	@GetMapping("/{userid}/mybookings")
	public ResponseEntity<?> getMyBooking(@PathVariable Long userid){
		System.out.println("searching for  myBookings");
		
		return ResponseEntity.ok(userService.getUserAndBookingDetails(userid));
		
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody @Valid SignInRequestDTO sdto){
		System.out.println("authenticating user....");
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.authenticatUser(sdto.getEmail(),sdto.getPassword()));
	}
	
	
	
	
}
