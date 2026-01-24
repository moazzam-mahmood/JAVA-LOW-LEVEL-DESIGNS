package com.examples.lld.parking_lot.ParkingLot;

import com.examples.lld.parking_lot.Entity.Vehicle;
import com.examples.lld.parking_lot.Ticket;

public class EntranceGate {

    public Ticket enterGate(Vehicle vehicle, ParkingBuilding building){
        return building.allocate(vehicle);
    }
}
