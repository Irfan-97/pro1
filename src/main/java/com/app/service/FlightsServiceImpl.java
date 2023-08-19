package com.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.FlightsDTO;
import com.app.entities.Flights;
import com.app.repository.FlightsRepository;


@Service
@Transactional
public class FlightsServiceImpl implements FlightsService {
	
	@Autowired
	private FlightsRepository flightsDao;
	
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public FlightsDTO addNewFlight(FlightsDTO flight) {
		Flights flightEntity=mapper.map(flight, Flights.class);
		Flights persistentFlight=flightsDao.save(flightEntity);
		return mapper.map(persistentFlight, FlightsDTO.class);
	}


	@Override
	public List<FlightsDTO> getFlights(String source, String destination, LocalDate journeyDate) {
		List<Flights> flightsList=flightsDao.getallflights(source, 	destination, journeyDate);
		
		return flightsList.stream()
				.map(fli->mapper.map(fli, FlightsDTO.class))
				.collect(Collectors.toList());
		
		
		
	}
	
	

}
