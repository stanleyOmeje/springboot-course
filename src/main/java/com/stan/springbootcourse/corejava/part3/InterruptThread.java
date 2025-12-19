package com.stan.springbootcourse.corejava.part3;

public class InterruptThread {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new WashingThread(new ThreadStatus()));
        thread.start();
        //Thread.sleep(100);
       // thread.interrupt();
    }
}
