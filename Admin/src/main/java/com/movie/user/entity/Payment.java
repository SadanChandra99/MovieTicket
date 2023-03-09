package com.movie.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private Integer paymentId;
	@Column(name = "payment_mode")
	private String paymentMode;
	@Column(name = "payment_price")
	private Double paymentPrice;
	@Column(name = "payment_status")
	private String paymentStatus;
	
	
	public Payment(Integer paymentId, String paymentMode, Double paymentPrice, String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.paymentMode = paymentMode;
		this.paymentPrice = paymentPrice;
		this.paymentStatus = paymentStatus;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public Double getPaymentPrice() {
		return paymentPrice;
	}
	public void setPaymentPrice(Double paymentPrice) {
		this.paymentPrice = paymentPrice;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentMode=" + paymentMode + ", paymentPrice=" + paymentPrice
				+ ", paymentStatus=" + paymentStatus + "]";
	}
	
	
	
	
	
	
	
	
	

}
