package com.examples.lld.multithreading.oddEvenPrinter;

public class Printer implements Runnable {
    static int counter = 1;
    private final int count;
    private final Object lock = new Object();

    public Printer(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {

                if(counter > count){
                    lock.notifyAll();
                    break;
                }

                if(counter%2==0 && Thread.currentThread().getName().equals("even")){
                    System.out.println("counter="+counter +" by "+Thread.currentThread().getName()+" thread");
                    counter++;
                    lock.notify();
                }
                else if(counter%2==1 && Thread.currentThread().getName().equals("odd")){
                    System.out.println("counter="+counter +" by "+Thread.currentThread().getName()+" thread");
                    counter++;
                    lock.notify();
                }else{
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
