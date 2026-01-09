package com.shanInfotech.Smartparking.entity;



import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.shanInfotech.Smartparking.enums.PaymentMode;
import com.shanInfotech.Smartparking.enums.PaymentStatus;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long ticketId;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    private LocalDateTime paymentTime;
    
    public Payment() {
    	
    }
    

    public Payment(Long ticketId, Double amount, PaymentMode paymentMode, PaymentStatus paymentStatus,
			LocalDateTime paymentTime) {
		super();
		this.ticketId = ticketId;
		this.amount = amount;
		this.paymentMode = paymentMode;
		this.paymentStatus = paymentStatus;
		this.paymentTime = paymentTime;
	}


	// getters & setters
    public Long getId() { return id; }

    public Long getTicketId() { return ticketId; }
    public void setTicketId(Long ticketId) { this.ticketId = ticketId; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public PaymentMode getPaymentMode() { return paymentMode; }
    public void setPaymentMode(PaymentMode paymentMode) { this.paymentMode = paymentMode; }

    public PaymentStatus getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(PaymentStatus paymentStatus) { this.paymentStatus = paymentStatus; }

    public LocalDateTime getPaymentTime() { return paymentTime; }
    public void setPaymentTime(LocalDateTime paymentTime) { this.paymentTime = paymentTime; }
}

