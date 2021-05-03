package com.epam.reservation.utility;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.epam.reservation.model.PaymentDto;

@FeignClient(name = "payment-service", url = "http://localhost:8084")
public interface PaymentFeignClient {
	@PostMapping("/v1/api/payments")
	public ResponseEntity<PaymentDto> addPayment(@RequestBody PaymentDto paymentDto);
}
