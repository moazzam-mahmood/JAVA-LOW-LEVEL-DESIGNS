package com.examples.lld.multithreading.pubSubModel;

import java.util.LinkedList;
import java.util.Queue;

public class PubSubClass {

    private final int capacity;
    Queue<Integer> queue;

    public PubSubClass(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<>();
    }

    public synchronized void produce(int value) {
        while(queue.size() >= capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        queue.add(value);
        System.out.println("produced " + value);
        notifyAll();

    }

    public synchronized void consume() {
        while(queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        int value = queue.poll();
        System.out.println("consumed " + value);
        notifyAll();

    }

}
