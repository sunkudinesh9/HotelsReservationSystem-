package com.epam.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelAddressDto {
	private int id;
	private String street;
	private String city;
	private String state;
	private int pinCode;
	private String country;
}
