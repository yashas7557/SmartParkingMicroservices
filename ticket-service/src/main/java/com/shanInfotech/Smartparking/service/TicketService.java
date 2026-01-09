package com.shanInfotech.Smartparking.service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.shanInfotech.Smartparking.dto.TicketDto;
import com.shanInfotech.Smartparking.entity.Ticket;
import com.shanInfotech.Smartparking.repository.TicketRepository;


@Service
public class TicketService {

    private final TicketRepository repo;

    public TicketService(TicketRepository repo) {
        this.repo = repo;
    }

    // Create Ticket (ENTRY)
    public TicketDto create(TicketDto dto) {
        Ticket ticket = new Ticket();
        ticket.setVehicleId(dto.getVehicleId());
        ticket.setParkingSlotId(dto.getParkingSlotId());
        ticket.setEntryTime(LocalDateTime.now());
        ticket.setStatus("ACTIVE");
        ticket.setAmount(dto.getAmount());

        return mapToDto(repo.save(ticket));
    }

    // Exit Ticket (CLOSE)
    public TicketDto closeTicket(Long id) {
        Ticket ticket = repo.findById(id).orElse(null);
        if (ticket == null) return null;

        ticket.setExitTime(LocalDateTime.now());
        ticket.setAmount(calculateAmount(ticket));
        ticket.setStatus("CLOSED");

        return mapToDto(repo.save(ticket));
    }

    public List<TicketDto> list() {
        return repo.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private Double calculateAmount(Ticket ticket) {
        return 50.0; // flat rate (can enhance later)
    }

    private TicketDto mapToDto(Ticket t) {
        TicketDto dto = new TicketDto();
        dto.setId(t.getId());
        dto.setVehicleId(t.getVehicleId());
        dto.setParkingSlotId(t.getParkingSlotId());
        dto.setEntryTime(t.getEntryTime());
        dto.setExitTime(t.getExitTime());
        dto.setAmount(t.getAmount());
        dto.setStatus(t.getStatus());
        return dto;
    }
}
