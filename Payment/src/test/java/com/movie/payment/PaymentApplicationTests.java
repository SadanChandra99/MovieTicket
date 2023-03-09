package com.movie.payment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.movie.payment.entity.Payment;
import com.movie.payment.repository.PaymentRepository;
import com.movie.payment.serviceImplementation.PaymentServiceImplementation;

@SpringBootTest
class PaymentApplicationTests {

	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private PaymentServiceImplementation paymentServiceImplementation;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void testAddPayment() {
		
		Payment payment = new Payment();
		payment.setPaymentId(1);
		payment.setPaymentMode("UPI");
		payment.setPaymentPrice(340.0);
		payment.setPaymentStatus("Paid");
		paymentRepository.save(payment);
		assertEquals("Paid", payment.getPaymentStatus());
		assertEquals("UPI", payment.getPaymentMode());
		
	}
	
	
	
	@Test
	void testgetPaymentById() {
		List<Payment> payments = new ArrayList<>();
		payments.add(new Payment(1, "CASH", 1200.0, "PAID"));
		payments.add(new Payment(2, "DEBIT-CARD", 560.0, "PAID"));
		payments.add(new Payment(1, "CREDIT-CARD", 207.0, "NOT-PAID"));
		paymentRepository.saveAll(payments);
		assertEquals("CASH", payments.get(0).getPaymentMode());
		assertEquals("PAID", payments.get(0).getPaymentStatus());
		assertEquals("CREDIT-CARD", payments.get(2).getPaymentMode());
	}
	
	@Test
	void testGetAllPayments() {
		List<Payment> allPayments = new ArrayList<>();
		allPayments.add(new Payment(1, "CASH", 1200.0, "PAID"));
		allPayments.add(new Payment(2, "DEBIT-CARD", 560.0, "PAID"));
		allPayments.add(new Payment(1, "CREDIT-CARD", 207.0, "NOT-PAID"));
		paymentRepository.saveAll(allPayments);
		assertEquals(3, allPayments.size());
		assertEquals("DEBIT-CARD", allPayments.get(1).getPaymentMode());
	}

}
