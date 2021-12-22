package com.java.threads;

public class PrintNumber {
    boolean evenFlag = false;
    //Prints even numbers
    public void printEven(int num){
        synchronized (this) {
            while(!evenFlag){
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Thread Interrupted" + e.getMessage());
                }
            }
            System.out.println(Thread.currentThread().getName() + " - " + num);
            evenFlag = false;
            // notify thread waiting for this object's lock
            notify();
        }
    }

    //Prints odd numbers
    public void printOdd(int num){
        synchronized (this) {
            while(evenFlag){
                try {
                    //make thread to wait
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Thread Interrupted" + e.getMessage());
                }
            }
            System.out.println(Thread.currentThread().getName() + " - " + num);
            evenFlag = true;
            // notify thread waiting for this object's lock
            notify();
        }
    }
    public static void main(String[] args) {
        PrintNumber printer = new PrintNumber();
        // creating two threads
        Thread t1 = new Thread(new OddNumbers(printer, 20), "Odd");
        Thread t2 = new Thread(new EvenNumbers(printer, 20), "Even");
        t1.start();
        t2.start();
    }
}
