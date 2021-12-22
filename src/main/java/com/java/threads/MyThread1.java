package com.java.threads;

public class MyThread1 extends Thread{
    SyncExample s;
    MyThread1(SyncExample s){
        this.s=s;
    }
    public void run(){
        s.printTable(5);
    }
}
