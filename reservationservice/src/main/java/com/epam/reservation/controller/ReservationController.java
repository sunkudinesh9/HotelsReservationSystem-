package com.epam.reservation.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/v1/api")
public interface ReservationController {

	@PostMapping("/reservations")
	public String addReservation();
	
	@GetMapping("/reservations/{reservationId}")
	public String getReservationDetails(@PathVariable int reservationId);
	
	@DeleteMapping("/reservations/{reservationId}")
	public String CancelReservation(@PathVariable int reservationId);

}
