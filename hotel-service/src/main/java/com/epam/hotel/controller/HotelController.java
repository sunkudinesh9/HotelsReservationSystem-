package com.epam.hotel.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.hotel.entity.Hotel;
import com.epam.hotel.model.ApiResponse;
import com.epam.hotel.model.HotelDto;

@RequestMapping("/v1/api")
public interface HotelController {

	@PostMapping("/hotels")

	public ApiResponse<Hotel> addHotel(@RequestBody HotelDto hotelDto);

	@GetMapping("/hotels")
	public ApiResponse<List<Hotel> > getHotels();

	@GetMapping("/hotels/{hotelId}")
	public ApiResponse<Hotel> getHotelById(@PathVariable int hotelId);

	@PutMapping("/hotels/{hotelId}")
	public  ApiResponse<Hotel> updateHotel(@RequestBody HotelDto hotelDto, @PathVariable int hotelId);

	@DeleteMapping("/hotels/{hotelId}")
	public ApiResponse<Hotel> deleteHotel(@PathVariable int hotelId);

}
