package com.epam.reservation.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ReservationControllerImpl implements ReservationController {
	
	@Override
	public String addReservation() {
		log.info("Adding Reservation");
		return "Reservation Done";
	}

	@Override
	public String getReservationDetails(int reservationId) {
		return "Reservation details"+reservationId;
	}
	
	public String CancelReservation(@PathVariable int reservationId) {
		return "Reservation Cancelled";
	}
	
	//get all reservations api required ??

}
