package com.examples.lld.multithreading.virtual_threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VirtualThreadDemo1 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        for (int i = 0; i < 10; i++) {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    fetchData();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

    }

    private static void fetchData() {
        try {
            Thread.sleep(2000); // simulate API call
            System.out.println("Fetched by: " + Thread.currentThread());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
