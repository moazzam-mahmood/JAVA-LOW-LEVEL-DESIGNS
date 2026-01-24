package com.examples.lld.parking_lot.SpotManagers;

import com.examples.lld.parking_lot.Entity.ParkingSpot;
import com.examples.lld.parking_lot.LookupStrategy.ParkingSpotLookupStrategy;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public abstract class ParkingSpotManager {

    private final List<ParkingSpot> spots;
    private final ParkingSpotLookupStrategy strategy;
    private final ReentrantLock lock = new ReentrantLock();


    public ParkingSpotManager(List<ParkingSpot> spots, ParkingSpotLookupStrategy strategy) {
        this.spots = spots;
        this.strategy = strategy;
    }

    // methods like park, unpark and hasFreeSpots

    public ParkingSpot parkVehicle(){
        lock.lock();
        try {
            ParkingSpot spot = strategy.selectParkingSpot(spots);
            if(spot != null) {
                spot.occupy();
                return spot;
            }
            throw new RuntimeException("No free parking spot available");
        }finally {
            lock.unlock();
        }
    }

    public void unparkVehicle(ParkingSpot spot) {
        lock.lock();
        try {
            spot.release();
        }finally {
            lock.unlock();
        }
    }

    public boolean hasFreeSpot(){
        lock.lock();
        try{
            for(ParkingSpot spot : spots){
                if(spot != null && spot.isFree()) return true;
            }
            return false;
        }finally {
            lock.unlock();
        }
    }
}
