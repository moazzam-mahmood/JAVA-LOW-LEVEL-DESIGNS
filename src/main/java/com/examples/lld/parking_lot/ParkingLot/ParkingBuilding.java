package com.examples.lld.parking_lot.ParkingLot;

import com.examples.lld.parking_lot.Entity.ParkingSpot;
import com.examples.lld.parking_lot.Entity.Vehicle;
import com.examples.lld.parking_lot.Ticket;

import java.util.List;

public class ParkingBuilding {

    private final List<ParkingLevel> levels;

    public ParkingBuilding(List<ParkingLevel> levels) {
        this.levels = levels;
    }

    //methods like allocate and release to delegate to parking level class
    //but it takes ticket to release the car and generate ticket upon spot assignment
    //So i'll make ticket class first

    public Ticket allocate(Vehicle vehicle) {
        for(ParkingLevel level : levels) {
            if(level.hasAvailableSpot(vehicle.getVehicleType())){
                ParkingSpot spot = level.parkVehicle(vehicle.getVehicleType());
                if(spot != null){
                    Ticket ticket = new Ticket(vehicle,level, spot);
                    System.out.println("Parking allocated at level: "
                            + level.getLevelNumber()
                            + " spot: " + spot.getSpotId());
                    return ticket;
                }
            }
        }
        throw new RuntimeException("Parking Full");
    }

    public void unparkVehicle(Ticket ticket) {
        ParkingLevel level = ticket.getParkingLevel();
        if(level != null){
            level.unparkVehicle(ticket.getVehicle().getVehicleType(),ticket.getParkingSpot());
        }
    }


}
