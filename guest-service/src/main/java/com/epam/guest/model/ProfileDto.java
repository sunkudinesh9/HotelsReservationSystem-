package com.epam.guest.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileDto {
	private String firstName;
	private String lastName;
	private String emailid;
	private long mobileNumber;
	private String street;
	private String city;
	private String state;
	private int pinCode;
	private String country;
}
