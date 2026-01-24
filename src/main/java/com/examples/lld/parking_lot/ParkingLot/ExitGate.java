package com.examples.lld.parking_lot.ParkingLot;

import com.examples.lld.parking_lot.Payment.Payment;
import com.examples.lld.parking_lot.Pricing.CostComputation;
import com.examples.lld.parking_lot.Ticket;

public class ExitGate {

    private final CostComputation costComputation;
    public ExitGate(CostComputation costComputation) {
        this.costComputation = costComputation;
    }

    public void completeExit(ParkingBuilding building, Ticket ticket, Payment payment) {
        double amount = costComputation.calculatePrice(ticket);

        boolean isSuccess = payment.pay(amount);
        if (!isSuccess) {
            throw new RuntimeException("Payment failed. Exit denied.");
        }

        building.unparkVehicle(ticket);
        System.out.println("Exit successful. Gate opened.");
    }
}
