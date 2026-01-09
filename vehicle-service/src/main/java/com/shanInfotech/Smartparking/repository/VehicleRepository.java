package com.shanInfotech.Smartparking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shanInfotech.Smartparking.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    boolean existsByVehicleNumber(String vehicleNumber);
}
