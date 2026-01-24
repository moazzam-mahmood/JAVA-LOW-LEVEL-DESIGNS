package com.examples.lld.parking_lot.Entity;

import com.examples.lld.parking_lot.Enums.VehicleType;

public class Vehicle {

    String vehicleNumber;
    VehicleType vehicleType;

    //constructors and getters
    public Vehicle(String vehicleNumber, VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
