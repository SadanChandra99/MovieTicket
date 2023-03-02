package com.customer.VO;

import com.customer.entity.Customer;

public class ResponseTemplateVO {
	
	private Customer customer;
	private Movie movie;
	
	
	
	public ResponseTemplateVO(Customer customer, Movie movie) {
		super();
		this.customer = customer;
		this.movie = movie;
	}
	public ResponseTemplateVO() {
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
