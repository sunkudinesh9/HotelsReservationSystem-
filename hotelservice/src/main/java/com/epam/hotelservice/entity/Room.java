package com.epam.hotelservice.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ROOM")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "ROOM_NUMBER")
	private int roomNumber;
	@Column(name = "ROOM_STATUS")
	private String roomStatus;
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ROOM_TYPE_ID")
	private RoomType roomType;
	@ManyToOne
	@JoinColumn(name = "HOTEL_ID")
	private Hotel hotel;

}
