package com.app.dto;

import java.time.LocalDate;
import java.time.LocalTime;


import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class FlightsDTO {

	
	private String flightSrNo;
	
	private String flightNo;
	
	
	private String source;
	
	
	private String Destination;
	
	
	private LocalTime deptTime;
	
	
	private LocalTime arrTime;
	
	private LocalDate journeyDate;
	
	private Long capacity;
	
}
