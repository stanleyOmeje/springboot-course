package com.stan.springbootcourse.corejava.part3.threads;

import java.util.ArrayList;
import java.util.List;

public class ThreadShow {
    public void showThread() throws InterruptedException {
        ThreadCount threadCount = new ThreadCount();
        List<Thread> threads = new ArrayList<>();
        for (int i =0; i<1000; i++) {
            Thread t = new Thread(new ThreadC(threadCount));
            t.start();
            threads.add(t);
        }
        for (Thread t : threads) {
            t.join();
        }
        System.out.println("I am done by " + Thread.currentThread().getName());
        System.out.println("The total count is " + threadCount.getCount());
    }
}
