package com.app.service;

import com.app.dto.SignInResponseDTO;
import com.app.dto.UserBookingsDTO;
import com.app.dto.UserDTO;

public interface UserService {
	
	UserDTO addNewUser(UserDTO user);
	
	SignInResponseDTO authenticatUser(String email, String password);
	
	UserBookingsDTO getUserAndBookingDetails(Long userid);

}
