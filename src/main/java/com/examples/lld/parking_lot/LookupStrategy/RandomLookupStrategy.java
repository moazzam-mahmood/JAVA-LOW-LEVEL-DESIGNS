package com.examples.lld.parking_lot.LookupStrategy;

import com.examples.lld.parking_lot.Entity.ParkingSpot;

import java.util.List;

public class RandomLookupStrategy implements ParkingSpotLookupStrategy {
    @Override
    public ParkingSpot selectParkingSpot(List<ParkingSpot> parkingSpots) {
        for(ParkingSpot spot : parkingSpots) {
            if(spot != null && spot.isFree()){
                return spot;
            }
        }
        throw new RuntimeException("No free parking spot");
    }
}
