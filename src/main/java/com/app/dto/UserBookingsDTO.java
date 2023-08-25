package com.app.dto;

import java.util.List;

import com.app.entities.UserRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class UserBookingsDTO {
	
	@JsonProperty(access=Access.READ_ONLY)
	private Long userId;
	
	private List<BookingRespDTO> ticketList;

}
