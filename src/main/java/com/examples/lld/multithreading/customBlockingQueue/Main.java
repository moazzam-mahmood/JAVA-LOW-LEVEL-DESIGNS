package com.examples.lld.multithreading.customBlockingQueue;

public class Main {

    public static void main(String[] args) {
        CustomBlockingQueue<Integer> queue = new CustomBlockingQueue<Integer>(1);

        Thread producer1 = new Thread(new Producer(queue), "Producer1");
        Thread producer2 = new Thread(new Producer(queue), "Producer2");

        Thread consumer1 = new Thread(new Consumer(queue), "Consumer1");
        Thread consumer2 = new Thread(new Consumer(queue), "Consumer2");

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();

    }
}
