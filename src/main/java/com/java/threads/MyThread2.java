package com.java.threads;

public class MyThread2 extends Thread{
    SyncExample s;
    MyThread2(SyncExample s){
        this.s=s;
    }
    public void run(){
        s.printTable(100);
    }
}
