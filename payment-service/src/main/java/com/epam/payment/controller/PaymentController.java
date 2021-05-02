package com.epam.payment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.payment.entity.Payment;
import com.epam.payment.model.PaymentDto;

@RequestMapping("/v1/api")
public interface PaymentController {
	
	@PostMapping("/payments")
	public ResponseEntity<Payment> addPayment(PaymentDto paymentDto);
	
	@GetMapping("/payments/{reservationId}")
	public ResponseEntity<Payment> getPaymentDetailsById(@PathVariable int reservationId);


}
