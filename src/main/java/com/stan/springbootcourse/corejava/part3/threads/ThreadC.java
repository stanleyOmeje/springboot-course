package com.stan.springbootcourse.corejava.part3.threads;

public class ThreadC implements Runnable {
    ThreadCount threadCount;
    public ThreadC(ThreadCount threadCount) {
        this.threadCount = threadCount;
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
