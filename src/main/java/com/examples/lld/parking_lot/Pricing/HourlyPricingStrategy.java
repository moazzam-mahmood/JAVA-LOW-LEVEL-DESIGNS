package com.examples.lld.parking_lot.Pricing;

import com.examples.lld.parking_lot.Ticket;

import java.time.LocalDateTime;

public class HourlyPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(Ticket ticket) {
        return (LocalDateTime.now().getSecond()- ticket.getEntryTime().getSecond())*10.0;
    }
}
