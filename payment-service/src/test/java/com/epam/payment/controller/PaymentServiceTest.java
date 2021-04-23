package com.epam.payment.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.epam.payment.repository.PaymentRepository;
import com.epam.payment.service.PaymentService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PaymentServiceTest extends AbstractBaseTest{
	
	@MockBean
	PaymentRepository paymentRepository;
	
	@Autowired
	private PaymentService paymentService;
	
	@Test
	public void addPaymentDeatilsTest() throws Exception{
		getPaymentDetails();
	}

}
