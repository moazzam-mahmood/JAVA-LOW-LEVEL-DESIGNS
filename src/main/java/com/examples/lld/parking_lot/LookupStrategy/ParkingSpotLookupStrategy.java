package com.examples.lld.parking_lot.LookupStrategy;

import com.examples.lld.parking_lot.Entity.ParkingSpot;

import java.util.List;

public interface ParkingSpotLookupStrategy {

    ParkingSpot selectParkingSpot(List<ParkingSpot> parkingSpots);
}
