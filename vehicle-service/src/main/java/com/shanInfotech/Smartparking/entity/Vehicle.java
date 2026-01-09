package com.shanInfotech.Smartparking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vehicleNumber;   // KA01AB1234
    private String vehicleType;     // CAR, BIKE, EV
    private String ownerName;
    
    
    public Vehicle() {
    	
    }


	public Vehicle(String vehicleNumber, String vehicleType, String ownerName) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.vehicleType = vehicleType;
		this.ownerName = ownerName;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getVehicleNumber() {
		return vehicleNumber;
	}


	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}


	public String getVehicleType() {
		return vehicleType;
	}


	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}


	public String getOwnerName() {
		return ownerName;
	}


	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
    
}