package com.examples.lld.multithreading.customBlockingQueue;

public class Producer implements Runnable {
    private final CustomBlockingQueue<Integer> queue;

    public Producer(CustomBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            int value = 0;
            while(true){
                queue.put(value++);
                Thread.sleep(500);
            }
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
