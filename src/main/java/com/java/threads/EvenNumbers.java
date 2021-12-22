package com.java.threads;

public class EvenNumbers implements Runnable{
    PrintNumber print;
    int max;
    EvenNumbers(PrintNumber print, int max){
        this.print = print;
        this.max = max;
    }
    @Override
    public void run() {
        for(int i = 2; i <= max; i+=2){
            print.printEven(i);
        }
    }
}
