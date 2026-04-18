package com.examples.lld.multithreading.executor_framework.cached_threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedPoolDemo {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i <= 10; i++) {
            int taskId = i;
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " :executing task" + taskId);
                }
            });
        }

        executor.shutdown();
    }
}
