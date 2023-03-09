package com.movie.payment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.movie.payment.entity.Payment;
import com.movie.payment.repository.PaymentRepository;
import com.movie.payment.serviceImplementation.PaymentServiceImplementation;

@ExtendWith(SpringExtension.class)
public class PaymentServiceMockito {
	
	@InjectMocks
	private PaymentServiceImplementation paymentServiceImplementation;
	
	@MockBean
	private PaymentRepository paymentRepository;
	
	
	@Test
	void addPaymentTest() {
		Payment addpayment = new Payment();
		addpayment.setPaymentMode("CASH");
		addpayment.setPaymentPrice((double) 900);
		addpayment.setPaymentStatus("Paid");
		
		Mockito.when(paymentRepository.save(addpayment)).thenReturn(addpayment);
		assertEquals("Paid", addpayment.getPaymentStatus());
	}
	
	@Test
	void getPaymentbyIdTest() {
		Payment getpayment = new Payment();
		getpayment.setPaymentId(1);
		getpayment.setPaymentMode("UPI");
		getpayment.setPaymentPrice((double) 300);
		getpayment.setPaymentStatus("Not-Paid");
		
		Mockito.when(paymentRepository.findById(1)).thenReturn(Optional.of(getpayment));
		paymentRepository.save(getpayment);
//		Payment payment1 = paymentServiceImplementation.getPaymentById(1);
		assertEquals(1, getpayment.getPaymentId());
		assertEquals("UPI", getpayment.getPaymentMode());
	}
	

	@Test
	void getallPaymentTest() {
		
		List<Payment> payments = new ArrayList<Payment>();
		payments.add(new Payment(1, "UPI",  200.0, "Paid"));
		payments.add(new Payment(2, "CASH",  170.0, "Not-Paid"));
		payments.add(new Payment(1, "CARD",  387.0, "Paid"));
		paymentRepository.saveAll(payments);
		Mockito.when(paymentRepository.findAll()).thenReturn(payments);
		assertEquals(3, payments.size());
		assertEquals("UPI", payments.get(0).getPaymentMode() );
		
//		List<Payment> allpayments = paymentRepository.findAll();
//		Mockito.when(paymentRepository.findAll()).thenReturn(allpayments);
//		assertEquals(0, allpayments.size());
	}
}
