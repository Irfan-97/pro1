package com.app.entities;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user")
@NoArgsConstructor
@Getter
@Setter

public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@Column
	private Long mobNo;
	
	@Column
	private String securityQues;
	
	@Column
	private String ans;
	
	@Column
	private UserRole role;
	

}
