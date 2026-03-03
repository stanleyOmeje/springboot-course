package com.stan.springbootcourse.corejava.part3.executorframework;

import java.util.concurrent.CompletableFuture;

public class EmailClass {
    public static void sendMail() throws InterruptedException {
        ThreadPoolClass.longJob();
        System.out.println("Email send");
    }

    public static CompletableFuture<Void> sendMailAsync(){
       return CompletableFuture.runAsync(()->{
            try {
                sendMail();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
