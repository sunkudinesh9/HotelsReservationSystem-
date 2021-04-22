package com.epam.guestservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CREDITCARD")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "CARD_NUMBER")
	private long cardNumber;
	@Column(name = "EXPAIR_DATE")
	private String expairDate;
	@Column(name = "CARD_HOLDER_NAME")
	private String cadrHolderName;
	@Column(name = "CARD_TYPE")
	private String cardType;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private User user;
}
