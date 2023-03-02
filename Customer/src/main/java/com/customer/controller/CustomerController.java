package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.VO.ResponseTemplateVO;
import com.customer.entity.Customer;
import com.customer.service.CustomerService;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	
	@PostMapping(value = "/add")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		Customer addcustomer = customerService.createCustomer(customer);
		return ResponseEntity.ok(addcustomer);
	}
	
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") String name){
		Customer customerbyid = customerService.getCustomerById(name);
		return ResponseEntity.ok(customerbyid);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		List<Customer> allcustomers = customerService.getAllCustomers();
		return ResponseEntity.ok(allcustomers);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ResponseTemplateVO> getCustomerAndMovieById(@PathVariable("id") String name){
		
		ResponseTemplateVO temp = customerService.getcustomerandmoviebyid(name);
		
		return ResponseEntity.ok(temp);
		
	}
	
}
