package com.epam.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomTypeDto {
	private int id;
	private String roomName;
	private float rentPerDay;
	private int roomCapacity;
	private Boolean isActive;
}
