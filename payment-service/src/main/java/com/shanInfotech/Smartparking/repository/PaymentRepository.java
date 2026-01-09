package com.shanInfotech.Smartparking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shanInfotech.Smartparking.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
