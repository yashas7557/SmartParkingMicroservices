package com.shanInfotech.Smartparking.controller;



import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.shanInfotech.Smartparking.dto.VehicleDto;
import com.shanInfotech.Smartparking.service.VehicleService;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    @PostMapping
    public VehicleDto create(@RequestBody VehicleDto dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<VehicleDto> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public VehicleDto get(@PathVariable Long id) {
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
