package com.epam.guest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	@Column(name = "FIRST_NAME")
	private String firstName;
	@NotNull
	@Column(name = "LAST_NAME")
	private String lastName;
	@NotNull
	@Email(regexp = "^(.+)@(.+)$")
	@Column(name = "EMAIL")
	private String emailid;
	@NotNull
	@Min(10)
	@Column(name = "MOBILE_NO")
	private long mobileNumber;
	@Column(name = "STREET")
	private String street;
	@Column(name = "CITY")
	private String city;
	@Column(name = "STATE")
	private String state;
	@NotNull
	@Column(name = "PINCODE")
	private int pinCode;
	@Column(name = "COUNTRY")
	private String country;
}
