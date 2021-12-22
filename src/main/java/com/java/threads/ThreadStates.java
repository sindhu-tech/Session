package com.java.threads;

public class ThreadStates implements Runnable {
    public static Thread t1;
    public static ThreadStates obj;

    public static void main(String [] args){
      obj=new ThreadStates();
      t1=new Thread(obj);
      System.out.println("The state of thread t1: " + t1.getState());
      t1.start();
      System.out.println("The state of thread t1 after invoking: " + t1.getState());
      //changing the name of the thread
        t1.setName("Name changed");
        System.out.println("After changing the name:"+t1.getName());
    }
    public void run(){
        ThreadsExample thread=new ThreadsExample();
        Thread t2=new Thread(thread);
        System.out.println("The state of thread t2: " + t2.getState());
        t2.start();
        System.out.println("The state of thread t2 after invoking: " + t2.getState());
        try
        {

            Thread.sleep(200);
        }
        catch (InterruptedException ie)
        {
            ie.printStackTrace();
        }

        System.out.println("The state of thread t2 after invoking the method sleep() on it - "+ t2.getState() );
        try
        {
            t2.join();
        }
        catch (InterruptedException ie)
        {
            ie.printStackTrace();
        }
        System.out.println("The state of thread t2 when it has completed it's execution - " + t2.getState());

    }

}


