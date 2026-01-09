package com.shanInfotech.Smartparking.controller;


import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.shanInfotech.Smartparking.dto.PaymentDto;
import com.shanInfotech.Smartparking.service.PaymentService;



@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping
    public PaymentDto pay(@RequestBody PaymentDto dto) {
        return service.pay(dto);
    }

    @GetMapping
    public List<PaymentDto> list() {
        return service.list();
    }
}
