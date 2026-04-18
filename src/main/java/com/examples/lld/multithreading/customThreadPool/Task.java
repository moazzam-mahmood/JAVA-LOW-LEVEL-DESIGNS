package com.examples.lld.multithreading.customThreadPool;

public class Task implements Runnable {

    private int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +
                " executing task " + taskId);
    }
}
