package com.examples.lld.multithreading.customThreadPool;

public class Main {

    public static void main(String[] args) {

        CustomThreadPool customThreadPool = new CustomThreadPool(3);

        for (int i = 0; i <= 10; i++) {
            int taskId = i;
            customThreadPool.submit(new Task(taskId));
        }

        customThreadPool.shutdown();
    }
}
