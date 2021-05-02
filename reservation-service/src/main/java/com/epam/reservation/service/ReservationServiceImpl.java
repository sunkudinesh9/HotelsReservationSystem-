package com.epam.reservation.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.epam.reservation.entity.Reservation;
import com.epam.reservation.exception.ReservationNotFoundException;
import com.epam.reservation.model.ApiResponse;
import com.epam.reservation.model.Hotel;
import com.epam.reservation.model.ReservationDto;
import com.epam.reservation.model.User;
import com.epam.reservation.repository.ReservationRepository;
import com.epam.reservation.utility.GuestFeignClient;
import com.epam.reservation.utility.HotelFeignClient;
import com.epam.reservation.utility.ReservationUtility;

import edu.umd.cs.findbugs.annotations.CheckForNull;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private GuestFeignClient guestFeignClient;
	@Autowired
	private HotelFeignClient hotelFeignClient;
	
	@CircuitBreaker(name = "guest-service", fallbackMethod = "addReservationFallback")
	public ResponseEntity<ApiResponse<Reservation>> addReservation(ReservationDto reservationDto) {
		log.info("Entered"+getClass().getName());
		Reservation reservation =null;
		User user = getGuestDetails(reservationDto);
		Hotel hotel = getHotelDetails(reservationDto);
		reservation=new  ReservationUtility().convert(reservationDto);
		if(user!=null) 
			reservation.setUserId(user.getId());
		if(hotel!=null)
			reservation.setHotelId(hotel.getId());
		return new ResponseEntity<>(new ApiResponse<>(reservationRepository.save(reservation), new Date(), "reservation Created"),HttpStatus.CREATED);
	}
	
	//@CircuitBreaker(name = "hotel-service", fallbackMethod = "getHotelDetailsFallback")
	public Hotel getHotelDetails (ReservationDto reservationDto) {
		Hotel hotel =null;
		hotel = hotelFeignClient.getHotelsByName(reservationDto.getHotelName()).getData();
		return hotel;
	}
	
	//@CircuitBreaker(name = "guest-service", fallbackMethod = "getGuestDetailsFallback")
	public User getGuestDetails(ReservationDto reservationDto) {
		User user = guestFeignClient.getUserByUserName(reservationDto.getUserName()).getBody().getData();
		return user;
	}
	
	/*
	 * public ResponseEntity<ApiResponse<String>> getHotelDetailsFallback(Exception
	 * exception,ReservationDto reservationDto) { return new ResponseEntity<>(new
	 * ApiResponse<>("Hotel Service is Down", new Date(),
	 * exception.getMessage()),HttpStatus.SERVICE_UNAVAILABLE); }
	 * 
	 * public ResponseEntity<ApiResponse<String>>
	 * getGuestDetailsFallback(ReservationDto reservationDto,Exception exception) {
	 * return new ResponseEntity<>(new ApiResponse<>("Guest Service is Down", new
	 * Date(), exception.getMessage()),HttpStatus.SERVICE_UNAVAILABLE); }
	 */
	
	
	  public ResponseEntity<ApiResponse<String>>
	  addReservationFallback(ReservationDto reservationDto,Exception exception) {
	  return new ResponseEntity<>(new ApiResponse<>("inzternal Server issue",
	  new Date(), exception.getMessage()),HttpStatus.SERVICE_UNAVAILABLE); }
	 

	public Reservation getReservationDetailsById(int reservationId) {
		Optional<Reservation> optionalReservation = reservationRepository.findById(reservationId);
		if (!optionalReservation.isPresent()) {
			throw new ReservationNotFoundException("Unble to find the Reservation");
		}
		return optionalReservation.get();
	}

	public List<Reservation> getAllReservations() {
		return reservationRepository.findAll();
	}

	public Reservation cancelReservation(ReservationDto reservationDto, int reservationId) {
		Reservation reservationEntity = new ReservationUtility().convert(reservationDto);
		Reservation reservation = getReservationDetailsById(reservationId);
		reservation.setBookingStatus(reservationEntity.getBookingStatus());
		reservation.setIsActive(reservationEntity.getIsActive());
		return reservationRepository.save(reservation);
	}

}