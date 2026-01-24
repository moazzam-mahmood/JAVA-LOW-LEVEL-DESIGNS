package com.examples.lld.parking_lot.SpotManagers;

import com.examples.lld.parking_lot.Entity.ParkingSpot;
import com.examples.lld.parking_lot.LookupStrategy.ParkingSpotLookupStrategy;

import java.util.List;

public class TwoWheelerParkingSpotManager extends ParkingSpotManager {

    /*
     1. Maintains a list of Two Wheeler Spots only
     2. Has its own lookup strategy
     3. Has its own lock, to avoid conflicts with other spot managers
     */
    public TwoWheelerParkingSpotManager(List<ParkingSpot> spots, ParkingSpotLookupStrategy strategy) {
        super(spots, strategy);
    }
}
