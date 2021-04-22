package com.epam.hotel.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.hotel.entity.Hotel;

@RequestMapping("/v1/api")
public interface HotelController {
	@PostMapping("/hotels")
	public Hotel addHotel(@RequestBody Hotel hotel);
}
