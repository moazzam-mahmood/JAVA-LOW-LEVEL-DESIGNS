package com.examples.lld.multithreading.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            int productId = i;
            Future<Integer> future =  executor.submit(new PriceFetcher(productId));
            futures.add(future);
        }

        System.out.println("All tasks submitted...");

        int totalPrice = 0;

        for(Future<Integer> future : futures) {
            totalPrice += future.get();
        }

        System.out.println("Total Price: " + totalPrice);
        executor.shutdown();
    }
}
