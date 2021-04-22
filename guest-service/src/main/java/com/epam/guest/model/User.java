package com.epam.guest.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private int id;
	private String status;
	private Boolean active;
	private Profile profile;
	private List<CreditCard> creditCard;
	private List<StayHistory> stayHistory;
}
