package com.epam.hotelservice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.epam.hotelservice.entity.Hotel;

@RestController
public class HotelServiceController implements HotelServiceControllerInterface {

	@Override
	public Hotel addHotel(Hotel hotel) {
		return hotel;
	}

}
