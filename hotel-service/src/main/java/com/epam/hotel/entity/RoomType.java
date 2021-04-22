package com.epam.hotel.entity;

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
@Table(name = "ROOM_TYPE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "ROOM_TYPE")
	private String roomName;
	@Column(name = "RENT_PER_DAY")
	private float rentPerDay;
	@Column(name = "ROOM_CAPACITY")
	private int roomCapacity;
	@Column(name = "IS_ACTIVE")
	private boolean isActive;
}
