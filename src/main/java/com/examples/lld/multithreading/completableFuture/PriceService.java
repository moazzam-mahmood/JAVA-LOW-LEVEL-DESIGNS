package com.examples.lld.multithreading.completableFuture;

public class PriceService {

    public int fetchPrice(String vendor) {
        try {
            System.out.println("Fetching from " + vendor +
                    " by " + Thread.currentThread().getName());

            Thread.sleep(2000);

            if (vendor.equals("Flipkart")) {
                throw new RuntimeException("Service down");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return 100;
    }

    public int applyTaxAndDiscount(int price) {
        return (int)(price * 1.1) - 20;
    }
}