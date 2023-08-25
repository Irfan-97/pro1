package com.app.dto;

import com.app.entities.Gender;
import com.app.entities.TicketType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString

public class BookingRespDTO {

	
	@JsonProperty(access=Access.READ_ONLY)
	private Long pnr_no;
	
	private String passName;
	
	private Long passContact;
	
	private int passAge;
	
	private Gender gender;
	
	private Double fare;
	
	private TicketType type;
	
	private String flightSrNo;
}

