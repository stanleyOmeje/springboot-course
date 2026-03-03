package com.stan.springbootcourse.corejava.part3.executorframework.CompletableFutureClass;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Exercise {
    public static void gettingQuotes() {

        var q1 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 100;
        });

        var q2 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 1000;
        });

        var q3 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 500;
        });
        q1.thenAccept(a1->System.out.println("printing q1 in time "+a1));
        q2.thenAccept(a1->System.out.println("printing q2 in time "+a1));
        q3.thenAccept(a1->System.out.println("printing q3 in time "+a1));

        var all = CompletableFuture.allOf(q1, q2, q3);
        all.thenRun(()-> {
            try {
                var q11 = q1.get();
                var q12 = q2.get();
                var q13 = q3.get();

                var maxTime = Math.max(q11, Math.max(q12,q13));

                System.out.println("The total time is "+maxTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

    }
    public static void main(String[] args) throws InterruptedException {
        gettingQuotes();
        Thread.sleep(2000);
    }
}
