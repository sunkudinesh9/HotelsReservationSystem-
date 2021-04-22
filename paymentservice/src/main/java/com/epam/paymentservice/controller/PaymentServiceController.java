package com.epam.paymentservice.controller;

import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class PaymentServiceController implements PaymentServiceControllerInterface {

	@Override
	public String addPayment() {
		log.info("Adding Payment");
		return "payment Done";
	}

	@Override
	public String getPaymentDetails(int reservationId) {
		return "payment details"+reservationId;
	}
	
	

}
