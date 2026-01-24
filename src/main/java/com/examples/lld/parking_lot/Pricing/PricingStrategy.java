package com.examples.lld.parking_lot.Pricing;

import com.examples.lld.parking_lot.Ticket;

public interface PricingStrategy {

     double calculatePrice(Ticket ticket);
}
