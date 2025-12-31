package com.stan.springbootcourse.corejava.part3;

import com.stan.springbootcourse.corejava.part3.utils.MailServer;

import java.util.concurrent.ExecutionException;

public class AsyncMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MailServer server = new MailServer();
        System.out.println("Starting Mail Main...");
        System.out.println(server.sendMailAsync().get());
        System.out.println("Doing some mail...");
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e) {}


    }
}
