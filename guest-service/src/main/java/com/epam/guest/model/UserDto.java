package com.epam.guest.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	private Boolean status;
	private ProfileDto profile;
	private List<CreditCardDto> creditCards;
	private String userName;
	private String password;
}
