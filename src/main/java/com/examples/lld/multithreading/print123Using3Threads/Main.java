package com.examples.lld.multithreading.print123Using3Threads;


public class Main {
    public static void main(String[] args) {
        PrinterClass printerClass = new PrinterClass();

        Thread onePrinterThread = new Thread(printerClass, "one");
        Thread twoPrinterThread = new Thread(printerClass, "two");
        Thread threePrinterThread = new Thread(printerClass, "three");

        onePrinterThread.start();
        twoPrinterThread.start();
        threePrinterThread.start();
    }
}
