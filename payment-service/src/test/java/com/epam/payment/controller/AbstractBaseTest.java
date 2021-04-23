package com.epam.payment.controller;

import com.epam.payment.model.Payment;


public class AbstractBaseTest {
	
	public Payment getPaymentDetails() {
		Payment payment = new Payment();
		payment.setId(111111);
		payment.setModeOfPayment("Credit Card");
		payment.setReservationId(1);
		payment.setStatus("Success");
		return payment;
		
	}

}
