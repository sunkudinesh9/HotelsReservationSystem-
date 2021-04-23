package com.epam.guest.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	private Boolean status;
	private Profile profile;
	private List<CreditCard> creditCard;
}
