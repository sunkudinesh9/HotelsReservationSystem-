package com.epam.reservation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.epam.reservation.model.Reservation;

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
	public String getReservationDetailsById(int reservationId) {
		return "Reservation details"+reservationId;
	}
	
	@Override
	public String CancelReservation(@PathVariable int reservationId) {
		return "Reservation Cancelled";
	}

	@Override
	public List<Reservation> getAllReservations() {
		return null;
	}
	

}
