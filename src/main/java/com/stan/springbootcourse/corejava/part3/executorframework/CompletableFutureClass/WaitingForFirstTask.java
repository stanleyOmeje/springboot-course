package com.stan.springbootcourse.corejava.part3.executorframework.CompletableFutureClass;

import java.util.concurrent.CompletableFuture;

public class WaitingForFirstTask {
    public static void show(){
        var t1 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 20;
        });

        var t2 = CompletableFuture.supplyAsync(()-> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 10;});

        var any = CompletableFuture.anyOf(t1, t2);
        any.thenAccept(System.out::println);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("The fastest is ...");
     show();
     Thread.sleep(3000);
    }
}
