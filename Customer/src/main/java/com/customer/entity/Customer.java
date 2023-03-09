package com.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@Column(name = "customer_name")
	private String customerName;
	@Column(name = "customer_email")
	private String customerEmail;
	@Column(name = "customer_password")
	private String customerPassword;
	@Column(name = "customer_mobile")
	private long customerMobile;
	@Column(name = "customer_address")
	private String customerAddress;
	@Column(name = "customer_booked_seats")
	private int customerBookedSeats;
	@Column(name = "customer_movieid")
	private Long customerMovieId;
	
	
	public Customer(String customerName, String customerEmail, String customerPassword, long customerMobile,
			String customerAddress, int customerBookedSeats, Long customerMovieId) {
		super();
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.customerMobile = customerMobile;
		this.customerAddress = customerAddress;
		this.customerBookedSeats = customerBookedSeats;
		this.customerMovieId = customerMovieId;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	public long getCustomerMobile() {
		return customerMobile;
	}
	public void setCustomerMobile(long customerMobile) {
		this.customerMobile = customerMobile;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public int getCustomerBookedSeats() {
		return customerBookedSeats;
	}
	public void setCustomerBookedSeats(int customerBookedSeats) {
		this.customerBookedSeats = customerBookedSeats;
	}
	public Long getCustomerMovieId() {
		return customerMovieId;
	}
	public void setCustomerMovieId(Long customerMovieId) {
		this.customerMovieId = customerMovieId;
	}
	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", customerEmail=" + customerEmail + ", customerPassword="
				+ customerPassword + ", customerMobile=" + customerMobile + ", customerAddress=" + customerAddress
				+ ", customerBookedSeats=" + customerBookedSeats + ", customerMovieId=" + customerMovieId + "]";
	}

	
	

}
