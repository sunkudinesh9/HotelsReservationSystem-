package com.epam.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import com.epam.hotel.entity.Hotel;
import com.epam.hotel.model.ApiResponse;
import com.epam.hotel.model.HotelDto;
import com.epam.hotel.service.HotelService;

@RestController
public class HotelControllerImpl implements HotelController {

	
	@Autowired
	HotelService hotelService;
	
	@Override
	public ApiResponse<Hotel> addHotel(HotelDto hotelDto) {
		return new ApiResponse<>(hotelService.addHotel(hotelDto),
				HttpStatus.CREATED,"Hotel added into DB.");
	}

	@Override
	public ApiResponse<List<Hotel>> getHotels() {
		return new ApiResponse<>(hotelService.getHotels(),
				HttpStatus.OK,"Success");
	}

	@Override
	public ApiResponse<Hotel> getHotelById(int hotelId) {
		return new ApiResponse<>(hotelService.getHotel(hotelId),
				HttpStatus.OK,"Success");
	}

	@Override
	public ApiResponse<Hotel> updateHotel(HotelDto hotelDto, int hotelId) {
		return new ApiResponse<>(hotelService.updateHotel(hotelDto, hotelId),
				HttpStatus.OK,"Hotel details updated successfully.");
	}

	@Override
	public ApiResponse<Hotel> deleteHotel(int hotelId) {
		return new ApiResponse<>(hotelService.deleteHotel(hotelId),
				HttpStatus.OK,"Hotel deleted successfully.");
	}

	

}
