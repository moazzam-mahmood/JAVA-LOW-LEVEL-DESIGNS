package com.examples.lld.multithreading.executor_framework.scheduled_threadpool;

import java.util.concurrent.*;

public class SchedulerDemo {

 /*   Executor
        ↓
    ExecutorService   --> Use when not scheduling
        ↓
    ThreadPoolExecutor   (normal tasks)
        ↓
    ScheduledThreadPoolExecutor (scheduled tasks)

     and
    ScheduledExecutorService = interface (for scheduling, they have schedule methods present)*/

    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        for (int i = 0; i < 10; i++) {
            int taskId = i;
            //start task after a fixed delay
            scheduler.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " : executing task : " + taskId);
                }
            }, 2, TimeUnit.SECONDS);
        }

        scheduler.shutdown();
    }
}
