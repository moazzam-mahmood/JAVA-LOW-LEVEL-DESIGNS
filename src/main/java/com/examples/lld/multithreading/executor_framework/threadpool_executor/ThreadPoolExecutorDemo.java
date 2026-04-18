package com.examples.lld.multithreading.executor_framework.threadpool_executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                4,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5)
        );


        for (int i = 0; i < 10; i++) {
            int taskId = i;

            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() +
                            " executing task " + taskId);
                }
            });
        }

        //executor.shutdown();
    }
}
