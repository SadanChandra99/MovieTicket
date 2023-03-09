package com.customer.valueobject;

import com.customer.entity.Customer;

public class ResponseTemplateValueObject {
	
	private Customer customer;
	private Movie movie;
	
	
	
	public ResponseTemplateValueObject(Customer customer, Movie movie) {
		super();
		this.customer = customer;
		this.movie = movie;
	}
	public ResponseTemplateValueObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	@Override
	public String toString() {
		return "ResponseTemplateVO [customer=" + customer + ", movie=" + movie + "]";
	}
	
	

}
