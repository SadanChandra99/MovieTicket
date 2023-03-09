package com.movie.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.user.entity.Payment;
import com.movie.user.service.PaymentService;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping(value = "/add")
	public ResponseEntity<Payment> addPayment(@RequestBody Payment payment){
		Payment addpayment = paymentService.addPayment(payment);
		return ResponseEntity.ok(addpayment);
	}
	
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable("id") Integer paymentId){
		Payment getpaymentbyid = paymentService.getPaymentById(paymentId);
		return ResponseEntity.ok(getpaymentbyid);
	}
	
	@GetMapping(value = "/getall")
	public ResponseEntity<List<Payment>> getAllPayments(){
		List<Payment> allPayments = paymentService.getAllPayments();
		return ResponseEntity.ok(allPayments);
	}
	
	
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment, @PathVariable("id") Integer paymentId){
		Payment updatePayment = paymentService.updatePayment(payment, paymentId);
		return ResponseEntity.ok(updatePayment);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> deletePayment(@PathVariable("id") Integer paymentId){
		String deletepayment = paymentService.deletePayment(paymentId);
		return ResponseEntity.ok(deletepayment);
	}

}
