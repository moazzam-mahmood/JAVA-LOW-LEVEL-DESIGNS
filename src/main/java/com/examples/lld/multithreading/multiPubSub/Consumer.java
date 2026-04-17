package com.examples.lld.multithreading.multiPubSub;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while(true){
                int value = queue.take();
                System.out.println(Thread.currentThread().getName() + ": consumed " + value);
                Thread.sleep(800);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
