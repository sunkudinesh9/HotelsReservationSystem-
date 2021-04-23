package com.epam.reservation.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "RESERVATION_DETAILS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "USER_ID")
	private int userId;
	@Column(name = "HOTEL_ID")
	private int hotelId;
	@Column(name = "PARTY_MIX")
	private int partyMix;
	@Column(name = "CHECK_IN_DATE")
	private Date checkInDate;
	@Column(name = "CHECK_OUT_DATE")
	private int checkOutDate;
	@Column(name = "TOTAL_COST")
	private float totalCost;
	@Column(name = "BOOKING_STATUS")
	private String bookingStatus;
	@Column(name = "PAYMENT_ID")
	private long paymentId;
	@Column(name = "IS_ACTIVE")
	private boolean isActive;

}
