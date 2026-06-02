package com.stan.springbootcourse.corejava.part3.executorservice;

public class LongRunningTask {
    public static void doJob() throws InterruptedException {
        Thread.sleep(3000);
    }
}
