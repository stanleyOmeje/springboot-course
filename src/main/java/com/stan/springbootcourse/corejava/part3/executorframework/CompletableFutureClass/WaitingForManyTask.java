package com.stan.springbootcourse.corejava.part3.executorframework.CompletableFutureClass;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class WaitingForManyTask {
    public static void show(){
        var t1 = CompletableFuture.supplyAsync(()->1);
        var t2 = CompletableFuture.supplyAsync(()->2);
        var t3 = CompletableFuture.supplyAsync(()->3);

        var all = CompletableFuture.allOf(t1, t2, t3);
        all.thenRun(()->{
            try {
                var t11 = t1.get();
                var t12 = t2.get();
                var t13 = t3.get();

                var result = t11 + t12 + t13;
               System.out.println("The result "+result);
                System.out.println("are all successfull");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static int show2(){
        var t1 = CompletableFuture.supplyAsync(()->1);
        var t2 = CompletableFuture.supplyAsync(()->2);
        var t3 = CompletableFuture.supplyAsync(()->3);

        var all = CompletableFuture.allOf(t1, t2, t3);
        AtomicInteger result = new AtomicInteger();
        all.thenRun(()->{
            try {
                var t11 = t1.get();
                var t12 = t2.get();
                var t13 = t3.get();

                result.set(t11 + t12 + t13);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        return result.get();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        show();
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(show2());
    }
}
