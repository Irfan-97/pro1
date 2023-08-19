package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.dto.FlightsDTO;

public interface FlightsService {
	FlightsDTO addNewFlight(FlightsDTO flight);
	
	List<FlightsDTO> getFlights(String source, String destination, LocalDate journeydate);

}
