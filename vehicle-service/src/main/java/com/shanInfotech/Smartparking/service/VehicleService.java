package com.shanInfotech.Smartparking.service;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.shanInfotech.Smartparking.dto.VehicleDto;
import com.shanInfotech.Smartparking.entity.Vehicle;
import com.shanInfotech.Smartparking.repository.VehicleRepository;



@Service
public class VehicleService {

    private final VehicleRepository repository;

    public VehicleService(VehicleRepository repository) {
        this.repository = repository;
    }

    // Create Vehicle
    public VehicleDto create(VehicleDto dto) {
        if (repository.existsByVehicleNumber(dto.getVehicleNumber())) {
            throw new RuntimeException("Vehicle already registered");
        }
        Vehicle vehicle = mapToEntity(dto);
        return mapToDto(repository.save(vehicle));
    }

    // List Vehicles
    public List<VehicleDto> list() {
        return repository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    // Get Vehicle by ID
    public VehicleDto get(Long id) {
        return repository.findById(id)
                .map(this::mapToDto)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
    }

    // Delete Vehicle
    public void delete(Long id) {
        repository.deleteById(id);
    }

    // --------- Mapper Methods ---------
    private Vehicle mapToEntity(VehicleDto dto) {
        Vehicle v = new Vehicle();
        v.setVehicleNumber(dto.getVehicleNumber());
        v.setVehicleType(dto.getVehicleType());
        v.setOwnerName(dto.getOwnerName());
        return v;
    }

    private VehicleDto mapToDto(Vehicle v) {
        VehicleDto dto = new VehicleDto();
        dto.setId(v.getId());
        dto.setVehicleNumber(v.getVehicleNumber());
        dto.setVehicleType(v.getVehicleType());
        dto.setOwnerName(v.getOwnerName());
        return dto;
    }
}
