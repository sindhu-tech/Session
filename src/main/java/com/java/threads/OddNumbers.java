package com.java.threads;

public class OddNumbers implements Runnable{
    PrintNumber print;
    int max;
    OddNumbers(PrintNumber print, int max){
        this.print = print;
        this.max = max;
    }
    @Override
    public void run() {
        for(int i = 1; i <= max; i+=2){
            print.printOdd(i);
        }
    }
}
