package com.epam.reservation.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.epam.reservation.model.Reservation;

public class ReservationService {

	public Reservation addReservation(Reservation reservation) {
		return reservation;
	}

	public Reservation getReservationDetailsById(int anyInt) {
		return new Reservation();
	}

	public List<Reservation> getAllReservations() {
		return Collections.emptyList();
	}

}
