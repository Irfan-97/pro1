package com.app.controller;


import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.FlightsDTO;
import com.app.service.FlightsService;

@RestController
@RequestMapping("/flights")
public class FlightsController {

	@Autowired
	private FlightsService flightservice;
	
	@PostMapping
	public ResponseEntity<?> addNewFlight(@RequestBody @Valid FlightsDTO dto){
		System.out.println("adding new flights...");
		return ResponseEntity.status(HttpStatus.CREATED).body(flightservice.addNewFlight(dto));
			
	}
	
	@GetMapping("/{source}/{destination}/{journeydate}")
	public ResponseEntity<?> getflights(@PathVariable String source, @PathVariable String destination,@PathVariable ("journeydate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate journeyDate){
	
		System.out.println("searching for flights...");
		List<FlightsDTO> list=flightservice.getFlights(source, destination, journeyDate);
		if(list.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
		return ResponseEntity.ok(list);
		
		
	}
	
}
