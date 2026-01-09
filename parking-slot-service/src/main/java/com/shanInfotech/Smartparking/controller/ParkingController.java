package com.shanInfotech.Smartparking.controller;



import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.shanInfotech.Smartparking.dto.ParkingSlotDto;
import com.shanInfotech.Smartparking.service.ParkingService;



@RestController
@RequestMapping("/api/parking")
public class ParkingController {

    private final ParkingService service;

    public ParkingController(ParkingService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ParkingSlotDto create(@RequestBody ParkingSlotDto dto) {
        return service.create(dto);
    }

    // GET ALL
    @GetMapping
    public List<ParkingSlotDto> getAll() {
        return service.getAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ParkingSlotDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
