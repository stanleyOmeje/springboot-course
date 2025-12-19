package com.stan.springbootcourse.corejava.part3;

public class WashingThread implements Runnable {
    ThreadStatus status;
    public WashingThread(ThreadStatus threadStatus) {
        status = threadStatus;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            if(Thread.currentThread().isInterrupted()) return;
            System.out.println("I am washing "+i);
            status.incrementNumber();
        }
    }
}
