package com.stan.springbootcourse.corejava.part3.utils;

import java.util.concurrent.CompletableFuture;

public class MailServer {

    public static String sendMail() {
        longJob();
       return "Mail sent successfully...";
    }

    public static CompletableFuture<String> sendMailAsync() {
        return CompletableFuture.supplyAsync(() -> sendMail());
    }

    public static void longJob(){
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
