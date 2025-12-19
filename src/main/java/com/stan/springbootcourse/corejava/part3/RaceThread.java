package com.stan.springbootcourse.corejava.part3;

import java.util.ArrayList;
import java.util.List;

public class RaceThread {
    public static void show() throws InterruptedException {
        ThreadStatus threadStatus = new ThreadStatus();
        List<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new WashingThread(threadStatus));
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Total execution is "+threadStatus.totalNumber);
    }

    public static void main(String[] args) throws InterruptedException {
        show();
    }
}
