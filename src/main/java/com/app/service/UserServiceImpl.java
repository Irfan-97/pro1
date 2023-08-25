package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.BookingRespDTO;
import com.app.dto.BookingsDTO;
import com.app.dto.SignInResponseDTO;
import com.app.dto.UserBookingsDTO;
import com.app.dto.UserDTO;
import com.app.entities.Bookings;
import com.app.entities.Flights;
import com.app.entities.User;
import com.app.repository.BookingRepository;
import com.app.repository.FlightsRepository;
import com.app.repository.UserRepository;


@Service
@Transactional

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private FlightsRepository flightDao;

	@Override
	public UserDTO addNewUser(UserDTO user) {
		User userEntity=mapper.map(user, User.class);
		User persistentUser=userDao.save(userEntity);
		return mapper.map(persistentUser, UserDTO.class);	
	}

	@Override
	public SignInResponseDTO authenticatUser(String email, String password) {
		User userEntity=userDao.findByEmailAndPassword(email, password);
		return mapper.map(userEntity, SignInResponseDTO.class);
		
	}

	@Override
	public UserBookingsDTO getUserAndBookingDetails(Long userid) {
		User user=userDao.getUserAndBookingDetails(userid);
		
		
		UserBookingsDTO userBookingResp=mapper.map(user, UserBookingsDTO.class);
		List<String> flightSrNos = new ArrayList<>();
		

		
		for (Bookings b : user.getTicketList()) {
	        if (b.getFlightSrNo() != null) {
	            String flightSrNo = b.getFlightSrNo().getFlightSrNo();
	            flightSrNos.add(flightSrNo); // Add the flightSrNo to the list
	        }
	    }
		
		for(int i=0; i<flightSrNos.size();i++) {
		
		userBookingResp.getTicketList().get(i).setFlightSrNo(flightSrNos.get(i));
		
		}
		  

//				
				
		
		return userBookingResp;
		
//		UserBookingsDTO userBookingsDTO = mapper.map(user, UserBookingsDTO.class);
//	    
//	    // Explicitly set the userId
//	    userBookingsDTO.setUserId(user.getUserId());
//	    userBookingsDTO.setTicketList(user.getTicketList());
//	    
//	    return userBookingsDTO;
		
	}
	
	
	
	
	
	

}

//List<BookingsDTO> list=new ArrayList<>();
//for(Bookings e:user.getTicketList()) {
//
////e.setFlightSrNo(flightDao.findByFlightSrNo(e.getFlightSrNo()));
//Flights flight=flightDao.findByFlightSrNo(e.getFlightSrNo());
//
//String fsrno=(flight.getFlightSrNo());
//
//}

//for(BookingRespDTO e:userBookingResp.getTicketList()) {
//	
//	//e.setFlightSrNo(flightDao.findByFlightSrNo(e.getFlightSrNo()));
//	Flights flight=flightDao.findByFlightSrNo(e.getFlightSrNo());
//	
//	String fsrno=(flight.getFlightSrNo());
//	
//	e.setFlightSrNo(fsrno);
//}


//for (Bookings b : user.getTicketList()) {
//if (b.getFlightSrNo() != null) {
//String fsrno = b.getFlightSrNo().getFlightSrNo();
//System.out.println(fsrno);
//} else {
//System.out.println("FlightSrNo is null for booking: " + b.getPnr_no());
//}
//}
