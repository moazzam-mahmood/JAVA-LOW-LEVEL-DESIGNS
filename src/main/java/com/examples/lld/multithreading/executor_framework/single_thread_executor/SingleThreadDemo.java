package com.examples.lld.multithreading.executor_framework.single_thread_executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadDemo {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            int taskId = i;
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " : executing task : " + taskId);
                }
            });
        }

        executor.shutdown();
    }
}
