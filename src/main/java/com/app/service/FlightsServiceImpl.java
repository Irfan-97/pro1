package com.app.service;

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

}
