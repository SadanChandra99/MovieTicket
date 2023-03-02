package com.customer.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	private String customerName;
	private String customerEmail;
	private String customerPassword;
	private long customerMobile;
	private String customerAddress;
	private int customerBookedSeats;
	private String customerMovieName;

	public Customer(String customerName, String customerEmail, String customerPassword, long customerMobile,
			String customerAddress, int customerBookedSeats, String customerMovieName) {
		super();
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.customerMobile = customerMobile;
		this.customerAddress = customerAddress;
		this.customerBookedSeats = customerBookedSeats;
		this.customerMovieName = customerMovieName;
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

	public String getCustomerMovieName() {
		return customerMovieName;
	}

	public void setCustomerMovieName(String customerMovieName) {
		this.customerMovieName = customerMovieName;
	}

	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", customerEmail=" + customerEmail + ", customerPassword="
				+ customerPassword + ", customerMobile=" + customerMobile + ", customerAddress=" + customerAddress
				+ ", customerBookedSeats=" + customerBookedSeats + ", customerMovieName=" + customerMovieName + "]";
	}
	
	

}
