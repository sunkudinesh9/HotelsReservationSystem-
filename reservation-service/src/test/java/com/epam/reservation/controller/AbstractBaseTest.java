package com.epam.reservation.controller;

import java.sql.Date;

import com.epam.reservation.model.Reservation;

public class AbstractBaseTest {
	
	public Reservation getReservationDetails() {
		
		Reservation reservation = new Reservation();
		reservation.setId(1);
		reservation.setActive(true);
		reservation.setBookingStatus("Booked");
	    String checkin="2021-05-05";  
	    Date checkinDate=Date.valueOf(checkin);
	    String checkout="2021-05-10";  
	    Date checkoutDate=Date.valueOf(checkout);
		reservation.setCheckInDate(checkinDate);
		reservation.setCheckOutDate(checkoutDate);
		reservation.setHotelId(123);
		reservation.setPartyMix(4);
		reservation.setPaymentId(111);
		reservation.setTotalCost(10000);
		reservation.setUserId(000);
		return reservation;
		
	}

}
