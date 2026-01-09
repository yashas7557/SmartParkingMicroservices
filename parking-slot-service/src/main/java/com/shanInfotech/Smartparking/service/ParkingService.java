package com.shanInfotech.Smartparking.service;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.shanInfotech.Smartparking.dto.ParkingSlotDto;
import com.shanInfotech.Smartparking.entity.ParkingSlot;
import com.shanInfotech.Smartparking.repository.ParkingSlotRepository;



@Service
public class ParkingService {

    private final ParkingSlotRepository repository;

    public ParkingService(ParkingSlotRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public ParkingSlotDto create(ParkingSlotDto dto) {
        ParkingSlot parking = mapToEntity(dto);
        ParkingSlot saved = repository.save(parking);
        return mapToDto(saved);
    }

    // GET ALL
    public List<ParkingSlotDto> getAll() {
        return repository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    // GET BY ID
    public ParkingSlotDto getById(Long id) {
        return repository.findById(id)
                .map(this::mapToDto)
                .orElse(null);
    }

    // DELETE
    public void delete(Long id) {
        repository.deleteById(id);
    }

    // MAPPERS
    private ParkingSlotDto mapToDto(ParkingSlot parking) {
        ParkingSlotDto dto = new ParkingSlotDto();
        dto.setId(parking.getId());
        dto.setLocation(parking.getLocation());
        dto.setSlotNumber(parking.getSlotNumber());
        dto.setAvailable(parking.getAvailable());
        return dto;
    }

    private ParkingSlot mapToEntity(ParkingSlotDto dto) {
        ParkingSlot parking = new ParkingSlot();
        parking.setLocation(dto.getLocation());
        parking.setSlotNumber(dto.getSlotNumber());
        parking.setAvailable(dto.getAvailable());
        return parking;
    }
}
