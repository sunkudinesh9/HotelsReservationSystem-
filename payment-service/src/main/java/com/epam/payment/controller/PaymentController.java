package com.epam.payment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/v1/api")
public interface PaymentController {
	
	@PostMapping("/payments")
	public String addPayment();
	
	@GetMapping("/payments/{reservationId}")
	public String getPaymentDetails(@PathVariable int reservationId);

}
