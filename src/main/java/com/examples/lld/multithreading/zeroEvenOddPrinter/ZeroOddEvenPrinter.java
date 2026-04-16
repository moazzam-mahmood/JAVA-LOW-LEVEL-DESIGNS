package com.examples.lld.multithreading.zeroEvenOddPrinter;

public class ZeroOddEvenPrinter implements Runnable {

    private static int OddCounter = 1;
    private static int EvenCounter = 2;

    private static String turn = "zero";

    @Override
    public void run() {
        synchronized (this) {
            try{
                while (true) {
                    if(Thread.currentThread().getName().equals("zero")){
                        while(!turn.equals("zero")){
                            wait();
                        }

                        System.out.println("0");
                        notifyAll();
                        turn = "odd";
                    }else if(Thread.currentThread().getName().equals("odd")){
                        while(!turn.equals("odd")){
                            wait();
                        }
                        System.out.println(OddCounter);
                        OddCounter+=2;
                        notifyAll();
                        turn = "even";
                    }else if(Thread.currentThread().getName().equals("even")){
                        while(!turn.equals("even")){
                            wait();
                        }
                        System.out.println(EvenCounter);
                        EvenCounter+=2;
                        notifyAll();
                        turn = "zero";
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
