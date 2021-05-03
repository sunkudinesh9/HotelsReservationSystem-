package com.epam.reservation.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.epam.reservation.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.googlecode.jmapper.annotations.JMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "RESERVATION_DETAILS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "USER_ID")
	private int userId;
	@Column(name = "HOTEL_ID")
	private int hotelId;
	@JMap
	@Column(name = "PARTY_MIX")
	private int partyMix;
	@JMap
	@Column(name = "CHECK_IN_DATE")
	private String checkInDate;
	@JMap
	@Column(name = "CHECK_OUT_DATE")
	private String checkOutDate;
	@JMap
	@Column(name = "TOTAL_COST")
	private float totalCost;
	@JMap
	@Column(name = "BOOKING_STATUS")
	private String bookingStatus;
	@Column(name = "PAYMENT_ID")
	private long paymentId;
	@JMap
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;
	@Column(name = "ROOM_NUMBER")
	private int roomNumber;
}
