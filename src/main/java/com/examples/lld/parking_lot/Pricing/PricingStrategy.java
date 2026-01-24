package com.examples.lld.parking_lot.Pricing;

import com.examples.lld.parking_lot.Ticket;

public interface PricingStrategy {

    public double calculatePrice(Ticket ticket);
}
