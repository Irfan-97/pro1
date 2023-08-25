package com.app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SignInResponseDTO {

	private Long userId;
	private String name;
	private  String role;
	private String email;
	
}
