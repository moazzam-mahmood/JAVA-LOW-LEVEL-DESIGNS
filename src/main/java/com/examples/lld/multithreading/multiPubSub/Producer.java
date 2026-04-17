package com.examples.lld.multithreading.multiPubSub;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int value = 0;
        try{
            while(true){
                System.out.println(Thread.currentThread().getName() + ": producing " + value);
                queue.put(value);
                value++;
                Thread.sleep(500);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
