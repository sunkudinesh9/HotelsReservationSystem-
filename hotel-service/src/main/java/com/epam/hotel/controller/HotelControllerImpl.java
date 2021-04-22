package com.epam.hotel.controller;

import org.springframework.web.bind.annotation.RestController;

import com.epam.hotel.entity.Hotel;

@RestController
public class HotelControllerImpl implements HotelController {

	@Override
	public Hotel addHotel(Hotel hotel) {
		return hotel;
	}

}
