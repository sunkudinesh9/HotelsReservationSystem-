package com.epam.guest.entity;

import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "USER_DETAILS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "ACTIVE")
	private Boolean active;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PROFILE_ID")
	private Profile profile;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<CreditCard> creditCard;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<StayHistory> stayHistory;
}
