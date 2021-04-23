package com.epam.reservation.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
	private int id;
	private Boolean active;
	private int userId;
	private int hotelId;
	private int partyMix;
	private Date checkInDate;
	private Date checkOutDate;
	private float totalCost;
	private String bookingStatus;
	private long paymentId;
	
}
