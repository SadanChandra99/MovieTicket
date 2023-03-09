package com.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.entity.Customer;
import com.customer.jwt.JwtUtills;
import com.customer.security.CustomerLoginDetails;
import com.customer.security.CustomerLoginDetailsService;
import com.customer.service.CustomerService;

@RestController
@RequestMapping(value = "/customer/auth")
public class AuthenticationController {
	
	@Autowired
	private CustomerLoginDetailsService customerLoginDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtills jwtUtills;
	
	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping(value = "/authentication")
	public ResponseEntity<String> authenticated(@RequestBody Customer customer) {
		
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(customer.getCustomerName(), customer.getCustomerPassword()));
		
		if(authentication.isAuthenticated()) {
			CustomerLoginDetails customerLoginDetails = (CustomerLoginDetails) customerLoginDetailsService.loadUserByUsername(customer.getCustomerName());
			String token = jwtUtills.generateJwtToken(customerLoginDetails);
			return ResponseEntity.ok(token);
		}
		
		return ResponseEntity.ok(customerService.notAutherizedMessage());
		
	}
	
	
	
}
