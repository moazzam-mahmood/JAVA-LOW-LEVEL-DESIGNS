package com.examples.lld.multithreading.future;

import java.util.concurrent.Callable;

public class PriceFetcher implements Callable<Integer> {

    private int productId;

    public PriceFetcher(int productId) {
        this.productId = productId;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Fetching price for product " + productId +
                " by " + Thread.currentThread().getName());

        // Simulate real world api processing delay
        Thread.sleep(1000);
        return productId*100;
    }
}
