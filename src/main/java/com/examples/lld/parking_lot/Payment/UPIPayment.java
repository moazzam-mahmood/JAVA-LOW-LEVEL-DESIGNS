package com.examples.lld.parking_lot.Payment;

public class UPIPayment implements Payment {
    @Override
    public boolean pay(double price) {
        System.out.println("Paid through UPI method with amount : " + price);
        return true;
    }
}
