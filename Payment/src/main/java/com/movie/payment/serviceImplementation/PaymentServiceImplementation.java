package com.movie.payment.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.payment.entity.Payment;
import com.movie.payment.repository.PaymentRepository;
import com.movie.payment.service.PaymentService;

@Service
public class PaymentServiceImplementation implements PaymentService{

	
	@Autowired
	private PaymentRepository paymentRepository;
	
	
	@Override
	public Payment addPayment(Payment payment) {
		// TODO Auto-generated method stub
		Payment addpayment = paymentRepository.save(payment);
		return addpayment;
	}

	@Override
	public Payment getPaymentById(Integer paymentId) {
		// TODO Auto-generated method stub
		Payment getPaymentById = paymentRepository.findById(paymentId).get();
		return getPaymentById;
	}

	@Override
	public List<Payment> getAllPayments() {
		// TODO Auto-generated method stub
		List<Payment> getAllPayments = paymentRepository.findAll();
		return getAllPayments;
	}

	@Override
	public Payment updatePayment(Payment payment, Integer paymentId) {
		// TODO Auto-generated method stub
		Payment updatePayment = paymentRepository.findById(paymentId).get();
		updatePayment.setPaymentMode(payment.getPaymentMode());
		updatePayment.setPaymentPrice(payment.getPaymentPrice());
		updatePayment.setPaymentStatus(payment.getPaymentStatus());
		paymentRepository.save(updatePayment);
		return updatePayment;
	}

	@Override
	public String deletePayment(Integer paymentId) {
		// TODO Auto-generated method stub
		paymentRepository.deleteById(paymentId);
		return "Payment Deleted Successfully";
	}

}
