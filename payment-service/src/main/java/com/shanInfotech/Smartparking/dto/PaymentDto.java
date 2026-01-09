package com.shanInfotech.Smartparking.dto;

import java.time.LocalDateTime;

import com.shanInfotech.Smartparking.enums.PaymentMode;
import com.shanInfotech.Smartparking.enums.PaymentStatus;

public class PaymentDto {
	private Long id;
    private Long ticketId;
    private Double amount;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
    private LocalDateTime paymentTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTicketId() {
		return ticketId;
	}
	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public PaymentMode getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public LocalDateTime getPaymentTime() {
		return paymentTime;
	}
	public void setPaymentTime(LocalDateTime paymentTime) {
		this.paymentTime = paymentTime;
	}
    
    
    
}
