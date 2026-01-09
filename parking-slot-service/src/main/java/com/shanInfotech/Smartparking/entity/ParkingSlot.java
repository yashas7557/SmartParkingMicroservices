package com.shanInfotech.Smartparking.entity;



import jakarta.persistence.*;

@Entity
@Table(name = "parking_slots")
public class ParkingSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;

    private Integer slotNumber;

    private Boolean available;

    public ParkingSlot() {}

    public ParkingSlot(String location, Integer slotNumber, Boolean available) {
        this.location = location;
        this.slotNumber = slotNumber;
        this.available = available;
    }

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
