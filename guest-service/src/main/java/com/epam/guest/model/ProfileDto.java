package com.epam.guest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
