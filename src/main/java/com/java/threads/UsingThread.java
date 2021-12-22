package com.java.threads;

public class UsingThread //extends Thread
{
    /*public void run(){
        System.out.println("Thread is running");

    }
    public static void main(String[]args){
        UsingThread t1=new UsingThread();
        t1.start();
    }*/
    //using the thread class(no need for the extends thread)
    public static void main(String[] args) {
        Thread t = new Thread("Thread created using the Thread class");
        t.start();
        String str=t.getName();
        System.out.println(str);
    }


}
