package com.examples.lld.multithreading.oddEvenPrinter;

public class OddEvenPrinter {
    private int counter = 1;
    private final int n;
    private final Object lock = new Object();

    public OddEvenPrinter(int n) {
        this.n = n;
    }

    public void printOdd(){
        synchronized (lock) {
            while (counter <= n) {
                if(counter % 2 == 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else{
                    System.out.println("Odd: " + counter);
                    counter++;
                    lock.notify();
                }
            }
        }
    }

    public void printEven(){
        synchronized (lock) {
            while (counter <= n) {
                if(counter % 2 != 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else{
                    System.out.println("Even: " + counter);
                    counter++;
                    lock.notify();
                }
            }
        }
    }
}
