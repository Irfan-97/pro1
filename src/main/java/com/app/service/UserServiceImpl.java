package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.UserDTO;
import com.app.entities.User;
import com.app.repository.UserRepository;


@Service
@Transactional

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public UserDTO addNewUser(UserDTO user) {
		User userEntity=mapper.map(user, User.class);
		User persistentUser=userDao.save(userEntity);
		return mapper.map(persistentUser, UserDTO.class);
		
		
	}

}
