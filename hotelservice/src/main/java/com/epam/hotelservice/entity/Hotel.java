package com.epam.hotelservice.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "HOTEL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "HOTEL_NAME")
	private String hotelName;
	@OneToOne
	@JoinColumn(name = "HOTEL_ADDRESS_ID")
	private HotelAddress hotelAddress;
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;
	@OneToMany(mappedBy = "hotel")
	private List<Room> room;
}
