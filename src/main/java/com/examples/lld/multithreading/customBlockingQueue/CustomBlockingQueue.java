package com.examples.lld.multithreading.customBlockingQueue;

import java.util.LinkedList;
import java.util.Queue;

public class CustomBlockingQueue<T> {
    private final Queue<T> queue;
    private final int capacity;

    public CustomBlockingQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    //put
    public synchronized void put(T value) throws InterruptedException {
        while(queue.size() >= capacity) {
            wait();
        }
        queue.add(value);
        System.out.println(Thread.currentThread().getName() + " produced: " + value);
        notifyAll();
    }

    //take
    public synchronized T take() throws InterruptedException {
        while(queue.isEmpty()) {
            wait();
        }

        T value = queue.poll();
        System.out.println(Thread.currentThread().getName() + " consumed: " + value);
        notifyAll();
        return value;
    }

    //size
    public synchronized int size() {
        return queue.size();
    }


}
