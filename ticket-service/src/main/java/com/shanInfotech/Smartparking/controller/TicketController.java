package com.shanInfotech.Smartparking.controller;


import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.shanInfotech.Smartparking.dto.TicketDto;
import com.shanInfotech.Smartparking.service.TicketService;



@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    @PostMapping
    public TicketDto create(@RequestBody TicketDto dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}/close")
    public TicketDto close(@PathVariable Long id) {
        return service.closeTicket(id);
    }

    @GetMapping
    public List<TicketDto> list() {
        return service.list();
    }
}
