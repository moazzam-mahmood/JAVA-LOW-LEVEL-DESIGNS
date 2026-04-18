package com.examples.lld.multithreading.customThreadPool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CustomThreadPool {

    private final Queue<Runnable> taskQueue;
    private final List<Worker> workers;
    private final int poolSize;
    private boolean isShutdown;

    public CustomThreadPool(int poolSize) {
        this.poolSize = poolSize;
        this.taskQueue = new LinkedList<Runnable>();
        this.workers = new ArrayList<>();
        this.isShutdown = false;

        for (int i = 0; i < poolSize; i++) {
            Worker worker = new Worker(taskQueue, this);
            workers.add(worker);
            worker.start();
        }
    }

    public void submit(Runnable task){
        synchronized (taskQueue) {
            if (isShutdown) {
                throw new IllegalStateException("Custom thread pool is closed");
            }

            taskQueue.add(task);
            taskQueue.notify();
        }
    }

    public void shutdown(){
        synchronized (taskQueue) {
            isShutdown = true;
            taskQueue.notifyAll();
        }
    }

    public boolean isShutdown(){
        return isShutdown;
    }
}
