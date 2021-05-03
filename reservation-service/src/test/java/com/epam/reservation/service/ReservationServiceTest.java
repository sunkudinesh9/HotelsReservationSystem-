package com.epam.reservation.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.epam.reservation.entity.Reservation;
import com.epam.reservation.model.ReservationDto;
import com.epam.reservation.repository.ReservationRepository;
import com.epam.reservation.utility.ReservationUtility;

class ReservationServiceTest {

	@Mock
	private ReservationRepository reservationRepository;

	@InjectMocks
	private ReservationServiceImpl reservationService;

	private ReservationUtility reservationUtility;
	private Reservation reservation;
	private ReservationDto reservationDto;

	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
		reservationUtility = new ReservationUtility();
		reservationDto = new ReservationDto();
		reservationDto.setId(1);
		reservationDto.setIsActive(true);
		reservationDto.setBookingStatus("Booked");
		String checkin = "2021-05-05";
		Date checkinDate = Date.valueOf(checkin);
		String checkout = "2021-05-10";
		Date checkoutDate = Date.valueOf(checkout);
		reservationDto.setCheckInDate(checkin);
		reservationDto.setCheckOutDate(checkout);
		reservationDto.setHotelName("ABC");
		reservationDto.setPartyMix(4);
//		reservationDto.setPaymentId(111);
		reservationDto.setTotalCost(10000);
		reservationDto.setUserName("test");
		reservation = reservationUtility.convert(reservationDto);
	}

	@Test
	void addReservationTest() {
		Mockito.when(reservationRepository.save(reservation)).thenReturn(reservation);
		Reservation reservationEntity = reservationService.addReservation(reservationDto).getBody().getData();
		Assertions.assertAll(() -> assertNotNull(reservationEntity),
				() -> assertEquals(reservationEntity.getBookingStatus(), reservationDto.getBookingStatus()));
	}

	@Test
	void getReservationsTest() {
		List<Reservation> reservations = new ArrayList<>();
		reservations.add(reservation);
		Mockito.when(reservationRepository.findAll()).thenReturn(reservations);
		List<Reservation> actualReservations = reservationService.getAllReservations();
		Assertions.assertNotNull(actualReservations);
		Assertions.assertTrue(actualReservations.size() > 0);
	}

	@Test
	void getReservationByIdTest() {
		Optional<Reservation> optionalReservation = Optional.of(reservation);
		Mockito.when(reservationRepository.findById(ArgumentMatchers.anyInt())).thenReturn(optionalReservation);
		Reservation actualReservation = reservationService.getReservationDetailsById(1);
		Assertions.assertAll(() -> assertNotNull(actualReservation),
				() -> assertEquals(actualReservation.getBookingStatus(), reservationDto.getBookingStatus()));
	}

	@Test
	void cancelReservationTest() {
		Optional<Reservation> optionalReservation = Optional.of(reservation);
		Mockito.when(reservationRepository.findById(ArgumentMatchers.anyInt())).thenReturn(optionalReservation);
		Reservation reservationEntity = reservationService.getReservationDetailsById(1);
		reservationEntity.setBookingStatus("Cancelld");
		Mockito.when(reservationRepository.save(reservationEntity)).thenReturn(reservationEntity);
		Reservation actualReservation = reservationService.cancelReservation(reservationDto, 1);
		Assertions.assertEquals(reservationEntity.getBookingStatus(), actualReservation.getBookingStatus());
	}

}
