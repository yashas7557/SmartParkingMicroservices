package com.shanInfotech.Smartparking.dto;



public class ParkingSlotDto {

    private Long id;
    private String location;
    private Integer slotNumber;
    private Boolean available;

    public ParkingSlotDto() {}

    public Long getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public Integer getSlotNumber() {
        return slotNumber;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setSlotNumber(Integer slotNumber) {
        this.slotNumber = slotNumber;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
