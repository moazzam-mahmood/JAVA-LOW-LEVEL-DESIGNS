package com.examples.lld.multithreading.completableFuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

    /*
    Standard CompletableFuture APIS:
    CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 100);
    CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                                System.out.println("Running task");
                                });
    future.thenApply(result -> result * 2);
    future.thenAccept(result -> System.out.println(result));
    future.thenRun(() -> System.out.println("Done"));

    *//* Chaining *//*
    CompletableFuture.supplyAsync(() -> 10)
            .thenApply(x -> x * 2)
            .thenApply(x -> x + 5)
            .thenAccept(System.out::println);
    */

    /*Requirements
    Fetch prices from 3 services in parallel -> Amazon, flipkart, walmart
    Add:
    base price
    tax (10%)
    discount (-20)
    Handle failures (if one service fails, ignore it)
    Return final aggregated price
    Should be non-blocking (no get() in between)*/

    public static void main(String[] args) {

        PriceService service = new PriceService();

        CompletableFuture<Integer> amazon =
                CompletableFuture.supplyAsync(() -> new FetchPriceTask(service, "Amazon").call())
                        .thenApply(price -> service.applyTaxAndDiscount(price))
                        .exceptionally(ex -> 0);

        CompletableFuture<Integer> flipkart =
                CompletableFuture.supplyAsync(() -> new FetchPriceTask(service, "Flipkart").call())
                        .thenApply(price -> service.applyTaxAndDiscount(price))
                        .exceptionally(ex -> 0);

        CompletableFuture<Integer> walmart =
                CompletableFuture.supplyAsync(() -> new FetchPriceTask(service, "Walmart").call())
                        .thenApply(price -> service.applyTaxAndDiscount(price))
                        .exceptionally(ex -> 0);

        CompletableFuture<Integer> total =
                amazon.thenCombine(flipkart, (a, b) -> a + b)
                        .thenCombine(walmart, (a, b) -> a + b);

        total.thenAccept(result ->
                System.out.println("Final Price: " + result)
        );

        total.join();
    }
}
