package com.epam.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
	private int id;
	private int roomNumber;
	private String roomStatus;
	private Boolean isActive;
	private RoomTypeDto roomType;
}
