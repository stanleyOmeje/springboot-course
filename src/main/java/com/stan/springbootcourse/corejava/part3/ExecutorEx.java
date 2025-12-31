package com.stan.springbootcourse.corejava.part3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class ExecutorEx {
    public String getName(){
        return "Chidozie";
    }
    public static void main(String[] args) {
        ExecutorEx executor = new ExecutorEx();

        var ex = Executors.newFixedThreadPool(5);
        try{
        for (int i = 0; i < 5; i++) {
            ex.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
            System.out.println("####################################");
            for (int i = 0; i < 5; i++) {
                ex.submit(() -> {
                    System.out.println("[Submit] My name is thread me-"+Thread.currentThread().getName());
                });
            }
            System.out.println("####################################");
            var future = ex.submit(()->{
                return executor.getName();
            });
            System.out.println("future is "+future.get());
    } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            ex.shutdown();
        }
    }
}
