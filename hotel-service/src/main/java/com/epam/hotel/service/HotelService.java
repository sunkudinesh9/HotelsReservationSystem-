package com.epam.hotel.service;

import java.util.List;

import com.epam.hotel.entity.Hotel;
import com.epam.hotel.model.HotelDto;

public interface HotelService {

	public Hotel addHotel(HotelDto hotelDto);

	public List<Hotel> getHotels();

	public Hotel getHotel(int hotelId);

	public Hotel updateHotel(HotelDto hotelDto, int hotelId);

	public Hotel deleteHotel(int hotelId);

}
