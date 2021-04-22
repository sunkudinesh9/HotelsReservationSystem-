package com.epam.hotelservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.hotelservice.entity.Hotel;

@RequestMapping("/v1/api")
public interface HotelServiceControllerInterface {
	@PostMapping("/hotels")
	public Hotel addHotel(@RequestBody Hotel hotel);
}