package com.shanInfotech.Smartparking.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.shanInfotech.Smartparking.entity.ParkingSlot;


public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Long> {
}
