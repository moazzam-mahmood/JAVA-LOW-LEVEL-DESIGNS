package com.examples.lld.parking_lot;

import com.examples.lld.parking_lot.Entity.ParkingSpot;
import com.examples.lld.parking_lot.Entity.Vehicle;
import com.examples.lld.parking_lot.ParkingLot.ParkingLevel;

import java.time.LocalDateTime;

public class Ticket {

    private final Vehicle vehicle;
    private final ParkingLevel parkingLevel;
    private final ParkingSpot parkingSpot;
    private final LocalDateTime entryTime;


    public Ticket(Vehicle vehicle, ParkingLevel parkingLevel, ParkingSpot parkingSpot) {
        this.vehicle = vehicle;
        this.parkingLevel = parkingLevel;
        this.parkingSpot = parkingSpot;
        this.entryTime = LocalDateTime.now();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingLevel getParkingLevel() {
        return parkingLevel;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }
}
