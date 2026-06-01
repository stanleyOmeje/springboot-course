package com.stan.springbootcourse.corejava.part3.threads.threadconcurrency;

import java.util.ArrayList;
import java.util.List;

public class ThreadShow {
    public void showThread() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        List<ThreadC> tasks = new ArrayList<>();
        for (int i =0; i<1000; i++) {

            var task = new ThreadC();
            tasks.add(task);

            Thread t = new Thread(task);
            t.start();
            threads.add(t);
        }
        for (Thread t : threads) {
            t.join();
        }
        System.out.println("I am done by " + Thread.currentThread().getName());
        int sum = tasks.stream()
                .map(t->t.threadCount)
                    .map(ThreadCount::getCount)
                        .reduce(0,Integer::sum);
        System.out.println("The total count is " + sum);
    }
}
