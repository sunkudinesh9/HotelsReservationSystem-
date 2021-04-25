package com.epam.guest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardDto {
	private long cardNumber;
	private String expiryDate;
	private String cardHolder;
	private String cardType;
}