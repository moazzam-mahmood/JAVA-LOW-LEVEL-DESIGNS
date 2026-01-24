package com.examples.lld.parking_lot.LookupStrategy;

import com.examples.lld.parking_lot.Entity.ParkingSpot;

import java.util.List;

public class NearestToEntryLookupStrategy implements ParkingSpotLookupStrategy {
    @Override
    public ParkingSpot selectParkingSpot(List<ParkingSpot> parkingSpots) {
        ParkingSpot selected = null;

        for (ParkingSpot spot : parkingSpots) {
            if(!spot.isFree()){
                continue;
            }

            if (selected == null ||
                    spot.getSpotId().compareTo(selected.getSpotId()) < 0) {
                selected = spot;
            }
        }

        if (selected == null) {
            throw new RuntimeException("No free parking spot available");
        }
        return selected;
    }
}
