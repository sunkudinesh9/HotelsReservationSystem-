package com.epam.hotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.hotel.entity.Hotel;
import com.epam.hotel.exception.HotelNotFoundException;
import com.epam.hotel.model.HotelDto;
import com.epam.hotel.repository.HotelRepository;
import com.epam.hotel.util.HotelUtility;
@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel addHotel(HotelDto hotelDto) {
		Hotel hotel = new HotelUtility().convert(hotelDto);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getHotels() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotel(int hotelId) {
		Optional<Hotel> optionalHotel = hotelRepository.findById(hotelId);
		if (!optionalHotel.isPresent()) {
			throw new HotelNotFoundException("Hotel not found.");
		}
		return optionalHotel.get();
	}

	@Override
	public Hotel updateHotel(HotelDto hotelDto, int hotelId) {
		Hotel updatedHotel = new HotelUtility().convert(hotelDto);
		Hotel existingHotel = getHotel(hotelId);
		existingHotel.setHotelAddress(updatedHotel.getHotelAddress());
		existingHotel.setRooms(updatedHotel.getRooms());
		existingHotel.setIsActive(true);
		existingHotel.setHotelName(updatedHotel.getHotelName());
		return hotelRepository.save(existingHotel);
	}

	@Override
	public Hotel deleteHotel(int hotelId) {
		Hotel hotel = getHotel(hotelId);
		hotelRepository.deleteById(hotelId);
		return hotel;
	}

	@Override
	public List<Hotel> getHotelsByName(String name) {
		List<Hotel> hotels = hotelRepository.findByHotelName(name);
		if (hotels.isEmpty()) {
			throw new HotelNotFoundException("Hotel not found.");
		}
		return hotels;
	}

}
