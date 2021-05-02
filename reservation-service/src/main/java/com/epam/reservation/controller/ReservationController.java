package com.epam.reservation.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.reservation.entity.Reservation;
import com.epam.reservation.model.ApiResponse;
import com.epam.reservation.model.ReservationDto;

@RequestMapping("/v1/api")
public interface ReservationController {

	@PostMapping("/reservations")
	public ResponseEntity<ApiResponse<Reservation>> addReservation(@RequestBody ReservationDto reservationDto);

	@GetMapping("/reservations/{reservationId}")
	public ResponseEntity<ApiResponse<Reservation>> getReservationDetailsById(@PathVariable int reservationId);

	@GetMapping("/reservations")
	public ResponseEntity<List<Reservation>> getAllReservations();

	@PutMapping("/reservations/{reservationId}")
	public ResponseEntity<ApiResponse<Reservation>> cancelReservation(@RequestBody ReservationDto reservationDto,@PathVariable int reservationId);

}
