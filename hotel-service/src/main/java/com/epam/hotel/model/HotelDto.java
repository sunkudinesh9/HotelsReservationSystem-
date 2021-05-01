package com.epam.hotel.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {
	private int id;
	private String hotelName;
	private HotelAddressDto hotelAddress;
	private Boolean isActive;
	private List<RoomDto> rooms;
}
