package com.epam.reservation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.epam.reservation.entity.ReservationDetails;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ReservationApplicationTest {

	TestRestTemplate restTemplate = new TestRestTemplate();
	
	@Test
	void contextLoads() {
		restTemplate.getForEntity("/v1/api/reservations/1", String.class);
	}

}
