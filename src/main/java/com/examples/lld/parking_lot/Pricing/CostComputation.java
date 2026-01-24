package com.examples.lld.parking_lot.Pricing;

import com.examples.lld.parking_lot.Ticket;

public class CostComputation {

    private final PricingStrategy strategy;


    public CostComputation(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculatePrice(Ticket ticket) {
        return strategy.calculatePrice(ticket);
    }
}
