package com.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.customer.VO.Movie;
import com.customer.VO.ResponseTemplateVO;
import com.customer.entity.Customer;
import com.customer.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Customer createCustomer(Customer customer) {
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
	
	public ResponseTemplateVO getcustomerandmoviebyid(String name) {
		ResponseTemplateVO vo = new ResponseTemplateVO();
		
		Customer customerbyid = customerRepository.findById(name).get();
		
		Movie movie = restTemplate.getForObject( "http://MOVIE-SERVICE/movie/get/" + customerbyid.getCustomerMovieName(), Movie.class);
		vo.setCustomer(customerbyid);
		vo.setMovie(movie);
		return vo;
	}

}
