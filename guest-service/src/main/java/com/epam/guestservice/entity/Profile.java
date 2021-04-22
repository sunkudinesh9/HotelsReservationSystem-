package com.epam.guestservice.entity;

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
@Table(name = "PROFILE_DETAILS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EMAIL")
	private String emailid;
	@Column(name = "MOBILE_NO")
	private long mobileNumber;
	@Column(name = "STREET")
	private String street;
	@Column(name = "CITY")
	private String city;
	@Column(name = "STATE")
	private String state;
	@Column(name = "PINCODE")
	private int pinCode;
	@Column(name = "COUNTRY")
	private String country;
}
