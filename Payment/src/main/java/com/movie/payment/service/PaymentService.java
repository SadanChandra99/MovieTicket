package com.movie.payment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.movie.payment.entity.Payment;

@Service
public interface PaymentService {
	
	public Payment addPayment(Payment payment);
	
	public Payment getPaymentById(Integer paymentId);
	
	public List<Payment> getAllPayments();
	
	public Payment updatePayment(Payment payment, Integer paymentId);
	
	public String deletePayment(Integer paymentId);

}
