package com.epam.reservation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {
	private int id;
	private Boolean isActive;
	private String userName;
	private String hotelName;
	private int partyMix;
	private String checkInDate;
	private String checkOutDate;
	private float totalCost;
	private String bookingStatus;
	private Payment payment;
	private String roomType;

}
