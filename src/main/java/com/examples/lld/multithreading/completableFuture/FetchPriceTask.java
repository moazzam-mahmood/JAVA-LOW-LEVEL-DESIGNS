package com.examples.lld.multithreading.completableFuture;

import java.util.concurrent.Callable;

public class FetchPriceTask implements Callable<Integer> {

    private final PriceService service;
    private final String vendor;

    public FetchPriceTask(PriceService service, String vendor) {
        this.service = service;
        this.vendor = vendor;
    }

    @Override
    public Integer call() {
        return service.fetchPrice(vendor);
    }
}