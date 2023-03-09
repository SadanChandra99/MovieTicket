package com.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.customer.entity.Customer;
import com.customer.repository.CustomerRepository;
import com.customer.valueobject.Movie;
import com.customer.valueobject.ResponseTemplateValueObject;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	
	public Customer createCustomer(Customer customer) {
//		Customer createcustomer = customerRepository.save(customer);
//		return createcustomer;
		
//		customer.setCustomerPassword(bCryptPasswordEncoder.encode(customer.getCustomerPassword()));
		Customer createcustomer = customerRepository.save(customer);
		return createcustomer;
	}
	
	public Customer getCustomerById(String name) {
		Customer getCustomerByid =  customerRepository.findById(name).get();
		return getCustomerByid;
	}
	
	public List<Customer> getAllCustomers(){
		List<Customer> allcustomers = customerRepository.findAll();
		return allcustomers;
	}
	
	public ResponseTemplateValueObject getcustomerandmoviebyid(String name) {
		ResponseTemplateValueObject vo = new ResponseTemplateValueObject();
		
		Customer customerbyid = customerRepository.findById(name).get();
		
		Movie movie = restTemplate.getForObject( "http://MOVIE-SERVICE/movie/get/" + customerbyid.getCustomerMovieId(), Movie.class);
		vo.setCustomer(customerbyid);
		vo.setMovie(movie);
		return vo;
	}
	
	public String notAutherizedMessage() {
		return "You are not autherized to access this page";
	}

}
