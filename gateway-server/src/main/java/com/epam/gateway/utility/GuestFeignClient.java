package com.epam.gateway.utility;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "guest-service", url = "http://localhost:8083")
public interface GuestFeignClient {

	@GetMapping("/validate/{token}")
	public Boolean validateToken(@PathVariable String token);
}