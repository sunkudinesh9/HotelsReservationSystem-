package com.epam.payment.controller;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.epam.payment.model.Payment;
import com.epam.payment.service.PaymentService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PaymentControllerTest extends AbstractBaseTest {
	
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private PaymentService paymentService;
	
	@Test
	void addPaymentTest() throws Exception {
		Payment payment = getPaymentDetails();
		String paymentData = objectMapper.writeValueAsString(payment);
		Mockito.when(paymentService.addPayment(payment)).thenReturn(payment);
		System.out.println("ResponseEntity: " + paymentService.addPayment(payment).getId());
		mockMvc.perform(MockMvcRequestBuilders.post("/v1/api/payments").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(paymentData)).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	void getPaymentDetailsTest() throws Exception {
		Payment payment = getPaymentDetails();
		Mockito.when(paymentService.getPaymentByReservationId(ArgumentMatchers.anyInt())).thenReturn(payment);
		mockMvc.perform(MockMvcRequestBuilders.get("/v1/api/payments/1")).andExpect(MockMvcResultMatchers.status().isOk());
	}
	

}
