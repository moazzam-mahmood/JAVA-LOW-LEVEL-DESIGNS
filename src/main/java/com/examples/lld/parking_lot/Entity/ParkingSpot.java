package com.examples.lld.parking_lot.Entity;

public class ParkingSpot {

    private final String spotId;
    private boolean isFree = true;


    public ParkingSpot(String spotId) {
        this.spotId = spotId;
    }

    public void release(){
        isFree = true;
    }

    public boolean isFree() {
        return isFree;
    }

    public void occupy() {
        isFree = false;
    }

    public String getSpotId() {
        return spotId;
    }
}
