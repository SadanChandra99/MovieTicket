package com.movie.payment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	@NotEmpty
	private Integer paymentId;
	@Column(name = "payment_mode")
	@NotEmpty
	private String paymentMode;
	@Column(name = "payment_price")
	@NotEmpty
	private Double paymentPrice;
	@Column(name = "payment_status")
	@NotEmpty
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
