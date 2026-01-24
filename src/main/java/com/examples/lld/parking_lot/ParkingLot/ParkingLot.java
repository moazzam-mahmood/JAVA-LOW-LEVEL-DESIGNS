package com.examples.lld.parking_lot.ParkingLot;

import com.examples.lld.parking_lot.Entity.Vehicle;
import com.examples.lld.parking_lot.Payment.Payment;
import com.examples.lld.parking_lot.Ticket;

public class ParkingLot {

    private final EntranceGate entranceGate;
    private final ExitGate exitGate;
    private final ParkingBuilding building;


    public ParkingLot(EntranceGate entranceGate, ExitGate exitGate, ParkingBuilding building) {
        this.entranceGate = entranceGate;
        this.exitGate = exitGate;
        this.building = building;
    }

    public Ticket vehicleArrives(Vehicle vehicle) {
        return entranceGate.enterGate(vehicle, building);
    }

    public void vehicleLeaves(Ticket ticket, Payment payment) {
        exitGate.completeExit(building, ticket,payment);
    }
}
