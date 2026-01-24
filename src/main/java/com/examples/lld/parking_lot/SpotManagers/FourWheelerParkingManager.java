package com.examples.lld.parking_lot.SpotManagers;

import com.examples.lld.parking_lot.Entity.ParkingSpot;
import com.examples.lld.parking_lot.LookupStrategy.ParkingSpotLookupStrategy;

import java.util.List;

public class FourWheelerParkingManager extends ParkingSpotManager{

    public FourWheelerParkingManager(List<ParkingSpot> spots, ParkingSpotLookupStrategy strategy) {
        super(spots, strategy);
    }
}
