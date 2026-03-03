package com.stan.springbootcourse.corejava.part3.executorframework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolClass {
    public static void logName(){
        System.out.println(Thread.currentThread().getName());
    }

    public static void longJob() throws InterruptedException {
        Thread.sleep(2000);
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var executorService = Executors.newFixedThreadPool(5);
//        for (int i = 0; i < 5; i++) {
//            executorService.submit(()->{
//                logName();
//            });
//        }
        var future = executorService.submit(()->{
            longJob();
            return 1;
        });
        System.out.println("Do more job");
        var you = future.get();
        System.out.println("you "+ you);

    }
}
