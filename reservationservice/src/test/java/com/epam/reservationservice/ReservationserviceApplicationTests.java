package com.epam.reservationservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.epam.reservationservice.entity.ReservationDetails;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ReservationserviceApplicationTests {

	TestRestTemplate restTemplate = new TestRestTemplate();
	
	@Test
	void contextLoads() {
		restTemplate.getForEntity("/v1/api/reservations/1", String.class);
	}

}
