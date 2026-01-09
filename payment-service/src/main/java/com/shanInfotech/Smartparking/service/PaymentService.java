package com.shanInfotech.Smartparking.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.shanInfotech.Smartparking.dto.PaymentDto;
import com.shanInfotech.Smartparking.entity.Payment;
import com.shanInfotech.Smartparking.enums.PaymentStatus;
import com.shanInfotech.Smartparking.repository.PaymentRepository;


@Service
public class PaymentService {

    private final PaymentRepository repo;

    public PaymentService(PaymentRepository repo) {
        this.repo = repo;
    }

    // Make Payment
    public PaymentDto pay(PaymentDto dto) {
        Payment payment = new Payment();
        payment.setTicketId(dto.getTicketId());
        payment.setAmount(dto.getAmount());
        payment.setPaymentMode(dto.getPaymentMode());
        payment.setPaymentStatus(PaymentStatus.SUCCESS); // simulate success
        payment.setPaymentTime(LocalDateTime.now());

        return mapToDto(repo.save(payment));
    }

    // List Payments
    public List<PaymentDto> list() {
        return repo.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private PaymentDto mapToDto(Payment p) {
        PaymentDto dto = new PaymentDto();
        dto.setId(p.getId());
        dto.setTicketId(p.getTicketId());
        dto.setAmount(p.getAmount());
        dto.setPaymentMode(p.getPaymentMode());
        dto.setPaymentStatus(p.getPaymentStatus());
        dto.setPaymentTime(p.getPaymentTime());
        return dto;
    }
}

