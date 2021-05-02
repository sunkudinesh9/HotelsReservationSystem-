package com.epam.hotel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.googlecode.jmapper.annotations.JMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "HOTEL_ADDRESS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "STREET")
	@JMap
	private String street;
	@Column(name = "CITY")
	@JMap
	private String city;
	@Column(name = "STATE")
	@JMap
	private String state;
	@Column(name = "PINCODE")
	@JMap
	private int pinCode;
	@Column(name = "COUNTRY")
	@JMap
	private String country;
}
