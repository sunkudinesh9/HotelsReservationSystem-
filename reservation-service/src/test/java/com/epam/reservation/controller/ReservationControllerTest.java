package com.epam.reservation.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.epam.reservation.model.Reservation;
import com.epam.reservation.service.ReservationService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ReservationControllerTest extends AbstractBaseTest{
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private ReservationService reservationService;
	
	@Test
	void addReservationTest() throws Exception {
		Reservation reservation = getReservationDetails();
		String ReservationData = objectMapper.writeValueAsString(reservation);
		Mockito.when(reservationService.addReservation(reservation)).thenReturn(reservation);
		System.out.println("ResponseEntity: " + reservationService.addReservation(reservation).getId());
		mockMvc.perform(MockMvcRequestBuilders.post("/v1/api/reservations").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(ReservationData)).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	void getReservationDetailsTest() throws Exception {
		Reservation reservation = getReservationDetails();
		Mockito.when(reservationService.getReservationDetailsById(ArgumentMatchers.anyInt())).thenReturn(reservation);
		mockMvc.perform(MockMvcRequestBuilders.get("/v1/api/reservations/1")).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	void getAllReservationsTest() throws Exception {
		List<Reservation> listOfReservations = new ArrayList<>();
		listOfReservations.add(getReservationDetails());
		Mockito.when(reservationService.getAllReservations()).thenReturn(listOfReservations);
		mockMvc.perform(MockMvcRequestBuilders.get("/v1/api/reservations")).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
}
