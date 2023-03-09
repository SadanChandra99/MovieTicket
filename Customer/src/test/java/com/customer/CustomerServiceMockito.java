package com.customer;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.customer.repository.CustomerRepository;
import com.customer.service.CustomerService;

@ExtendWith(SpringExtension.class)
public class CustomerServiceMockito {

	@InjectMocks
	CustomerService customerService;
	
	@MockBean
	CustomerRepository customerRepository;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@BeforeAll
	static void setUpBeforeClass() {
		
	}
	
	@AfterAll
	static void tearDownAfterClass() {
		
	}
	
	@BeforeEach
	void setUp() {
		
	}
	
	@AfterEach
	void tearDown() {
		
	}
	
	
	
}
