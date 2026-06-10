package com.stan.springbootcourse.corejava.part3.completablefutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class WaitingForTask {

    public static int show() throws ExecutionException, InterruptedException {
        var first = CompletableFuture.supplyAsync(()->1);
        var second = CompletableFuture.supplyAsync(()->2);
        var third = CompletableFuture.supplyAsync(()->3);

        var all  = CompletableFuture.allOf(first, second, third);

        int r1 = first.get();
        int r2 = second.get();
        int r3 = third.get();

        int sum = r1 + r2 + r3;

        return sum;
    }

    public static void show2() throws ExecutionException, InterruptedException {
        var first = CompletableFuture.supplyAsync(()->1);
        var second = CompletableFuture.supplyAsync(()->2);

        first
            .thenCombine(second, Integer::sum)
            .thenAccept(System.out::println);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("The sum of waiting is "+show());
        System.out.println("The sum of combining is :");
        show2();
    }
}
