package com.stan.springbootcourse.corejava.part3.executorframework.CompletableFutureClass;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class HandlingTimeout {
    public static void show() throws ExecutionException {
        var longTask = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 20;
        });
        try {
            var resullt = longTask.orTimeout(1000, TimeUnit.MILLISECONDS)
                .get();
            System.out.println(resullt);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

        public static void showWithDefault() throws ExecutionException {
            var longTask = CompletableFuture.supplyAsync(()->{
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return 20;
            });
            try {
                var resullt = longTask.completeOnTimeout(30,1000, TimeUnit.MILLISECONDS)
                    .get();
                System.out.println(resullt);
            }catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        showWithDefault();
        Thread.sleep(2000);
    }
}
