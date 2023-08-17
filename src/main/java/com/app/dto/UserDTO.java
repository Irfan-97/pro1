package com.app.dto;


import javax.validation.constraints.Email;

import com.app.entities.UserRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class UserDTO {
	
	@JsonProperty(access=Access.READ_ONLY)
	private Long userId;
	
	
	private String name;
	
	@Email
	private String email;
	
	
	private String password;
	
	
	private Long mobNo;
	
	
	private String securityQues;
	
	
	private String ans;
	
	
	private UserRole role;

}
