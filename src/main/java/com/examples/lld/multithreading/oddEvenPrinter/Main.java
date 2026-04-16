package com.examples.lld.multithreading.oddEvenPrinter;

public class Main {

    public static void main(String[] args) {

        Printer printer = new Printer(10);

        Thread oddPrinterThread = new Thread(printer, "odd");
        Thread evenPrinterThread = new Thread(printer, "even");
        oddPrinterThread.start();
        evenPrinterThread.start();


        /*OddEvenPrinter oddEvenPrinter = new OddEvenPrinter(10);
        Thread oddThread = new Thread(() -> oddEvenPrinter.printOdd());
        Thread evenThread = new Thread(() -> oddEvenPrinter.printEven());

        oddThread.start();
        evenThread.start();*/

    }
}
