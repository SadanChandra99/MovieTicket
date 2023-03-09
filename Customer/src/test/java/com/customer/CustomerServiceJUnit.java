package com.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.customer.entity.Customer;
import com.customer.repository.CustomerRepository;
import com.customer.service.CustomerService;

@SpringBootTest
public class CustomerServiceJUnit {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	@BeforeAll
	static void setUpBeforeClass() {
		System.out.println("Before All");
	}
	
	@AfterAll
	static void tearDownAfterClass() {
		System.out.println("After All");
	}
	
	@BeforeEach
	void setUp() {
		System.out.println("Before Each");
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("After Each");
	}
	
	@Test
	void testAddCustomer() {
		Customer customer = new Customer("uditya patel", "uditya@gmail.com", "uditya@123", 789375423, "bihar", 2, (long) 4);
		customerRepository.save(customer);
		Customer addcustomer = customerService.createCustomer(customer);
		assertEquals("uditya@gmail.com", addcustomer.getCustomerEmail());
		assertEquals("uditya@123", addcustomer.getCustomerPassword());
		assertEquals("bihar", addcustomer.getCustomerAddress());
	}
	
	@Test
	void getCustomerByIdTest() {
		List<Customer> allcustomers = new ArrayList<>();
		allcustomers.add(new Customer("sadan chandra", "sadan@gmail.com", "sadan@123", 76453683, "hyderabad", 2, (long) 1));
		allcustomers.add(new Customer("suman sarkar", "suman@gmail.com", "suman@123", 918237457, "kolkata", 2, (long) 2));
		customerRepository.saveAll(allcustomers);
		Customer customer = customerService.getCustomerById("suman sarkar");
		assertEquals("suman@gmail.com", customer.getCustomerEmail());
		assertEquals("kolkata", customer.getCustomerAddress());
		assertEquals(918237457, customer.getCustomerMobile());
		assertEquals(2, customer.getCustomerBookedSeats());
	
		
	}
	
	
	@Test
	void getAllCustomersTest() {
		List<Customer> allcustomers = new ArrayList<>();
		allcustomers.add(new Customer("sadan chandra", "sadan@gmail.com", "sadan@123", 76453683, "hyderabad", 2, (long) 1));
		allcustomers.add(new Customer("suman sarkar", "suman@gmail.com", "suman@123", 918237457, "kolkata", 2, (long) 2));
		allcustomers.add(new Customer("tirthesh das", "tirthesh@gmail.com", "tirthesh@123", 998793, "mumbai", 4, (long) 3));
		customerRepository.saveAll(allcustomers);
		List<Customer> customers = customerService.getAllCustomers();
		assertEquals(4, customers.size());
		Customer customer = customers.get(1);
		assertEquals("sadan chandra",customer.getCustomerName());
	}

}
