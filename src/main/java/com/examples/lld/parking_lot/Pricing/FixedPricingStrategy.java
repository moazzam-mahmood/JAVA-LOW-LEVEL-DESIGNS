package com.examples.lld.parking_lot.Pricing;

import com.examples.lld.parking_lot.Enums.VehicleType;
import com.examples.lld.parking_lot.Ticket;

public class FixedPricingStrategy implements PricingStrategy {

    @Override
    public double calculatePrice(Ticket ticket) {
        if(ticket.getVehicle().getVehicleType().equals(VehicleType.TWO_WHEELER)){
            return 20.0;
        }
        else if(ticket.getVehicle().getVehicleType().equals(VehicleType.FOUR_WHEELER)){
            return 40.0;
        }

        throw new RuntimeException("Unsupported vehicle type");
    }
}
