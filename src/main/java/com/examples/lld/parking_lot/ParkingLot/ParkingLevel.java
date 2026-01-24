package com.examples.lld.parking_lot.ParkingLot;

import com.examples.lld.parking_lot.Entity.ParkingSpot;
import com.examples.lld.parking_lot.Enums.VehicleType;
import com.examples.lld.parking_lot.SpotManagers.ParkingSpotManager;

import java.util.Map;

public class ParkingLevel {

    private final int levelNumber;
    private final Map<VehicleType, ParkingSpotManager> managers;

    public ParkingLevel(int levelNumber, Map<VehicleType, ParkingSpotManager> managers) {
        this.levelNumber = levelNumber;
        this.managers = managers;
    }

    public ParkingSpot parkVehicle(VehicleType vehicleType) {
        ParkingSpotManager manager = managers.get(vehicleType);
        if (manager == null) {
            throw new IllegalArgumentException(
                    "No parking manager for vehicle type: " + vehicleType);

        }
        return manager.parkVehicle();
    }

    public void unparkVehicle(VehicleType vehicleType,ParkingSpot parkingSpot) {
        ParkingSpotManager manager = managers.get(vehicleType);
        if(manager != null) {
            manager.unparkVehicle(parkingSpot);
        }
    }

    public boolean hasAvailableSpot(VehicleType vehicleType) {
        ParkingSpotManager manager = managers.get(vehicleType);
        return manager != null && manager.hasFreeSpot();
    }

    public int getLevelNumber() {
        return levelNumber;
    }
}
