package com.java.threads;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class PoolMain {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);//creating a pool of 5 threads
        for (int i = 0; i < 10; i++) {
            Runnable pool = new PoolExample("" + i);
            executor.execute(pool);//calling execute method of ExecutorService
        }
        executor.shutdown();
        while (!executor.isTerminated()) {   }

        System.out.println("Finished all threads");
        Executor exe=Executors.newSingleThreadExecutor();
        exe.execute(()->System.out.println("hello"));

    }
}

