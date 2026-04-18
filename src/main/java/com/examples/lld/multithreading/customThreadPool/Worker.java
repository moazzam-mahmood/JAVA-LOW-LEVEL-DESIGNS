package com.examples.lld.multithreading.customThreadPool;

import java.util.Queue;

public class Worker extends Thread {
    private final Queue<Runnable> taskQueue;
    private final CustomThreadPool customThreadPool;

    public Worker(Queue<Runnable> taskQueue, CustomThreadPool customThreadPool) {
        this.taskQueue = taskQueue;
        this.customThreadPool = customThreadPool;
    }

    @Override
    public void run() {
        while(true){
            Runnable task;

            synchronized (taskQueue){

                while(taskQueue.isEmpty() && !customThreadPool.isShutdown()){
                    try {
                        taskQueue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                if(customThreadPool.isShutdown() && taskQueue.isEmpty()){
                    return;
                }

                task = taskQueue.poll();
            }

            try {
                task.run();
            } catch (Exception e) {
                System.out.println("Task failed: " + e.getMessage());
            }
        }
    }
}
