package com.shanInfotech.Smartparking.dto;

import java.time.LocalDateTime;

public class TicketDto {

    private Long id;
    private Long vehicleId;
    private Long parkingSlotId;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private Double amount;
    private String status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}
	public Long getParkingSlotId() {
		return parkingSlotId;
	}
	public void setParkingSlotId(Long parkingSlotId) {
		this.parkingSlotId = parkingSlotId;
	}
	public LocalDateTime getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(LocalDateTime entryTime) {
		this.entryTime = entryTime;
	}
	public LocalDateTime getExitTime() {
		return exitTime;
	}
	public void setExitTime(LocalDateTime exitTime) {
		this.exitTime = exitTime;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
    
}