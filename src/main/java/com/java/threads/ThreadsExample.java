package com.java.threads;

public class ThreadsExample implements Runnable{
    public void run(){
        try {
            Thread.sleep(100);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("The state of thread t1 while it invoked the method join() on thread t2 -"+ ThreadStates.t1.getState());

        try {
            Thread.sleep(200);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
