package com.java.threads;

public class UsingRunnable implements Runnable{
    public void run(){
        System.out.println("Thread is running");

    }
    /*
    //using the constructor Thread(Runnable r)
    public static void main(String[]args){
        UsingRunnable t1=new UsingRunnable();
        Thread r1=new Thread(t1);
        r1.start();
    }
    */
    //using the constructor Thread(Runnable r,String name)
    public static void main(String[]args){
        Runnable r1=new UsingRunnable();
        Thread t1=new Thread(r1,"New Thread using constructor");
        t1.start();
        String str=t1.getName();
        System.out.println(str);
    }





}
