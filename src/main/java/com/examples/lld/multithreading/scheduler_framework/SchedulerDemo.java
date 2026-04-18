package com.examples.lld.multithreading.scheduler_framework;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SchedulerDemo {
    public static void main(String[] args) {

        // Two ways to initialize the scheduler, both are correct
        /*ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(2);*/

        ScheduledExecutorService scheduler =
                new ScheduledThreadPoolExecutor(2);

        // Task runs every 2 second
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println(Thread.currentThread().getName() +
                    " running task");
        }, 1, 2, TimeUnit.SECONDS);

        // Stop after 10 second
        scheduler.schedule(() -> {
            System.out.println("Shutting down...");
            scheduler.shutdown();
        }, 10, TimeUnit.SECONDS);
    }
}
