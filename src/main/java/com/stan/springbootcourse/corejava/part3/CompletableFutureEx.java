package com.stan.springbootcourse.corejava.part3;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletableFutureEx {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        var future = CompletableFuture.runAsync(runnable);
        future.get();
       System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        Supplier supplier = () -> {
            Random random = new Random();
            return random.nextInt(100);
        };
        var futures = CompletableFuture.supplyAsync(supplier);
        System.out.println(futures.get());
    }
}
