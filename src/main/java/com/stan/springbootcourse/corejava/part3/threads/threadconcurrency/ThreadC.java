package com.stan.springbootcourse.corejava.part3.threads.threadconcurrency;

public class ThreadC implements Runnable {
    ThreadCount threadCount;
    public ThreadC() {
        this.threadCount = new ThreadCount();
    }

    @Override
    public void run() {
        System.out.println(" Thread Name: "+Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        threadCount.increment();
        System.out.println("Download Completed "+Thread.currentThread().getName());
    }
}
