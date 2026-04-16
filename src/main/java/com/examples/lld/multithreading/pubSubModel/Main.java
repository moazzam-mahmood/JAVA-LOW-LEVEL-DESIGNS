package com.examples.lld.multithreading.pubSubModel;

public class Main {
    public static void main(String[] args) {
        PubSubClass pubSubClass = new PubSubClass(10);

        Thread producerThread = new Thread(() -> {
            for(int i = 0; i < 100; i++) {
                pubSubClass.produce(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumerThread = new Thread(() -> {
            for(int i = 0; i < 100; i++) {
                pubSubClass.consume();
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
