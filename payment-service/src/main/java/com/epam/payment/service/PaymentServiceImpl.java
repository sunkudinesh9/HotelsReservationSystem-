package com.epam.payment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.payment.entity.Payment;
import com.epam.payment.exception.PaymentNotFoundException;
import com.epam.payment.model.PaymentDto;
import com.epam.payment.repository.PaymentRepository;
import com.epam.payment.utility.PaymentUtility;
@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;

	public Payment addPayment(PaymentDto paymentDto) {
		return paymentRepository.save(new PaymentUtility().convert(paymentDto));
	}

	public Payment getPaymentByReservationId(int anyInt) {
		Optional<Payment> optionalUser = paymentRepository.findById(anyInt);
		if (!optionalUser.isPresent()) {
			throw new PaymentNotFoundException("Unble to find the User");
		}
		return optionalUser.get();
	}
}
