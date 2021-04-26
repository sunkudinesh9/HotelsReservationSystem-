package com.epam.guest.model;

import java.util.List;

import com.googlecode.jmapper.annotations.JMap;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	private Boolean status;
	private ProfileDto profile;
	@JMap
	private List<CreditCardDto> creditCards;
}
