package com.examples.lld.multithreading.zeroEvenOddPrinter;

public class Main {

    public static void main(String[] args) {

        ZeroOddEvenPrinter printer = new ZeroOddEvenPrinter();

        Thread zeroPrinterThread = new Thread(printer, "zero");
        Thread oddPrinterThread = new Thread(printer, "odd");
        Thread evenPrinterThread = new Thread(printer, "even");

        zeroPrinterThread.start();
        oddPrinterThread.start();
        evenPrinterThread.start();
    }
}
