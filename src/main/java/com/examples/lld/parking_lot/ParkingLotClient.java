package com.examples.lld.parking_lot;

import com.examples.lld.parking_lot.Entity.ParkingSpot;
import com.examples.lld.parking_lot.Entity.Vehicle;
import com.examples.lld.parking_lot.Enums.VehicleType;
import com.examples.lld.parking_lot.LookupStrategy.NearestToEntryLookupStrategy;
import com.examples.lld.parking_lot.LookupStrategy.ParkingSpotLookupStrategy;
import com.examples.lld.parking_lot.ParkingLot.*;
import com.examples.lld.parking_lot.Payment.CashPayment;
import com.examples.lld.parking_lot.Payment.UPIPayment;
import com.examples.lld.parking_lot.Pricing.CostComputation;
import com.examples.lld.parking_lot.Pricing.HourlyPricingStrategy;
import com.examples.lld.parking_lot.SpotManagers.FourWheelerParkingManager;
import com.examples.lld.parking_lot.SpotManagers.ParkingSpotManager;
import com.examples.lld.parking_lot.SpotManagers.TwoWheelerParkingSpotManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotClient {

    public static void main(String[] args) throws InterruptedException {
        ParkingSpotLookupStrategy strategy = new NearestToEntryLookupStrategy();

        Map<VehicleType, ParkingSpotManager> levelOneManagers =new HashMap<>();
        levelOneManagers.put(VehicleType.TWO_WHEELER, new TwoWheelerParkingSpotManager(List.of(
                new ParkingSpot("L1-S1"),new ParkingSpot("L1-S2"), new ParkingSpot("L1-S3")), strategy));

        levelOneManagers.put(VehicleType.FOUR_WHEELER,
                new FourWheelerParkingManager(List.of(new ParkingSpot("L1-S4")), strategy));


        Map<VehicleType, ParkingSpotManager> levelTwoManagers =new HashMap<>();
        levelTwoManagers.put(VehicleType.TWO_WHEELER, new TwoWheelerParkingSpotManager(List.of(
                new ParkingSpot("L2-S1")), strategy));

        levelTwoManagers.put(VehicleType.FOUR_WHEELER,
                new FourWheelerParkingManager(List.of(new ParkingSpot("L2-S2"),
                        new ParkingSpot("L2-S3")), strategy));


        ParkingLevel level1 = new ParkingLevel(1, levelOneManagers);
        ParkingLevel level2 = new ParkingLevel(2, levelTwoManagers);

        ParkingBuilding building1 = new ParkingBuilding(List.of(level1,level2));

        ParkingLot myParkingLot = new ParkingLot(new EntranceGate(),new ExitGate(new CostComputation(new HourlyPricingStrategy())),building1);

        Vehicle bike = new Vehicle("BIKE-101", VehicleType.TWO_WHEELER);
        Vehicle car = new Vehicle("CAR-201", VehicleType.FOUR_WHEELER);

        Ticket t1 = myParkingLot.vehicleArrives(bike);
        Ticket t2 = myParkingLot.vehicleArrives(car);

        Thread.sleep(5000);

        myParkingLot.vehicleLeaves(t1, new CashPayment());
        myParkingLot.vehicleLeaves(t2, new UPIPayment());



    }
}
