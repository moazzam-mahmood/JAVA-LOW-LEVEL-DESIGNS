package com.examples.lld.multithreading.customBlockingQueue;

public class Consumer implements Runnable {
    private final CustomBlockingQueue<Integer> queue;

    public Consumer(CustomBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            while(true){
                queue.take();
                Thread.sleep(800);

            }
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
