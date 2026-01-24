package com.examples.lld.parking_lot.Payment;

public class CashPayment implements Payment {
    @Override
    public boolean pay(double price) {
        System.out.println("Cash paid: " + price);
        return true;
    }
}
