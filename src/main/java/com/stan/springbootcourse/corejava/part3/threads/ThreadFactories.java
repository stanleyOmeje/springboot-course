package com.stan.springbootcourse.corejava.part3.threads;

import java.util.ArrayList;
import java.util.List;

public class ThreadFactories {
    public void createThreads() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        Thread thread;
        for(int i=0; i<10; i++){
            int finalI = i;
            thread = new Thread(new Runnable(){
                @Override
                public void run() {
                    System.out.println(finalI +" Thread Name: "+Thread.currentThread().getName());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Download Completed "+Thread.currentThread().getName());
                }
            });
            thread.start();
            threads.add(thread);
        }
        for (Thread t : threads) {
            t.join();
        }
    }
}
