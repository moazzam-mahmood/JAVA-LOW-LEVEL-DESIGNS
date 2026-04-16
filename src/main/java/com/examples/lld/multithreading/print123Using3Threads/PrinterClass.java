package com.examples.lld.multithreading.print123Using3Threads;

public class PrinterClass implements Runnable {

    private static int turn = 1;

    @Override
    public void run() {
        synchronized (this) {
            try {
                while (true) {
                    if(Thread.currentThread().getName().equals("one")) {
                        while(turn != 1){
                            wait();
                        }
                        System.out.println("1");
                        notifyAll();
                        turn = 2;
                    } else if (Thread.currentThread().getName().equals("two")) {
                        while(turn != 2){
                            wait();
                        }
                        System.out.println("2");
                        notifyAll();
                        turn = 3;
                    }else if (Thread.currentThread().getName().equals("three")) {
                        while(turn != 3){
                            wait();
                        }
                        System.out.println("3");
                        notifyAll();
                        turn = 1;
                    }
                }
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}
