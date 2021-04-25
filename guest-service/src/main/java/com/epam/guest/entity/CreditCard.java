package com.epam.guest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	@Column(name = "CARD_NUMBER")
	private long cardNumber;
	@NotNull
	@Column(name = "EXPAIR_DATE")
	private String expairDate;
	@NotNull
	@Column(name = "CARD_HOLDER_NAME")
	private String cadrHolderName;
	@NotNull
	@Column(name = "CARD_TYPE")
	private String cardType;
	@ManyToOne()
	@JoinColumn(name = "USER_ID")
	@JsonIgnore
	private User user;
}
