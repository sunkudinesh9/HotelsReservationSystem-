package com.epam.guest.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	private Boolean status;
	private ProfileDto profileDto;
	private List<CreditCardDto> creditCardDto;
}
