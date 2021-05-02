package com.epam.hotel.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.epam.hotel.entity.Hotel;
import com.epam.hotel.model.ApiResponse;
import com.epam.hotel.model.HotelDto;
import com.epam.hotel.service.HotelService;

@RestController
public class HotelControllerImpl implements HotelController {

	
	private static final String SUCCESS = "Success";
	@Autowired
	HotelService hotelService;
	
	@Override
	public ApiResponse<Hotel> addHotel(HotelDto hotelDto) {
		return new ApiResponse<>(hotelService.addHotel(hotelDto),
				new Date(),"Hotel added into DB.");
	}

	@Override
	public ApiResponse<List<Hotel>> getHotels() {
		return new ApiResponse<>(hotelService.getHotels(),
				new Date(),SUCCESS);
	}

	@Override
	public ApiResponse<Hotel> getHotelById(int hotelId) {
		return new ApiResponse<>(hotelService.getHotel(hotelId),
				new Date(),SUCCESS);
	}

	@Override
	public ApiResponse<Hotel> updateHotel(HotelDto hotelDto, int hotelId) {
		return new ApiResponse<>(hotelService.updateHotel(hotelDto, hotelId),
				new Date(),"Hotel details updated successfully.");
	}

	@Override
	public ApiResponse<Hotel> deleteHotel(int hotelId) {
		return new ApiResponse<>(hotelService.deleteHotel(hotelId),
				new Date(),"Hotel deleted successfully.");
	}

	@Override
	public ApiResponse<List<Hotel>> getHotelByName(String name) {
		return new ApiResponse<>(hotelService.getHotelsByName(name),
				new Date(),SUCCESS);
	}

	

}
