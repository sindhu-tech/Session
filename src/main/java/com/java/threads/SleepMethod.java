package com.java.threads;

public class SleepMethod extends Thread {
    /*
    //sleep method on custom thread
    public void run() {
        for (int i = 1; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }
    public static void main(String args[]) {
        SleepMethod t1 = new SleepMethod();
        SleepMethod t2 = new SleepMethod();

        t1.start();
        t2.start();
    }
     */

    //sleep method on main thread
    public static void main(String[]args){
        try {
            for (int j = 0; j < 5; j++)
            {
                // The main thread sleeps for the 1000 milliseconds, which is 1 sec
                 Thread.sleep(1000);
                //sleep time is negative ,we get interrupted Exception
                //Thread.sleep(-100);
                 // displaying the value of the variable
                System.out.println(j);
            }
        }
        catch (Exception expn)
        {
            System.out.println(expn);
        }
    }
}

