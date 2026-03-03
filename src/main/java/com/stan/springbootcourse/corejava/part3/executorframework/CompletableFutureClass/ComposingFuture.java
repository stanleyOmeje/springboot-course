package com.stan.springbootcourse.corejava.part3.executorframework.CompletableFutureClass;

import java.util.concurrent.CompletableFuture;

public class ComposingFuture {
    public static CompletableFuture<String> getEmail(String id) {
        String email = "chidozie@gmail.com";
       // return CompletableFuture.completedFuture(email);
        return CompletableFuture.supplyAsync(() -> email);
    }

    public static CompletableFuture<String> getPassword(String email) {
        String pword = "stan123";
        //return CompletableFuture.completedFuture(pword);
        return CompletableFuture.supplyAsync(() -> pword);
    }

    public static void show() {
//        var result = CompletableFuture
//            .supplyAsync(()-> getEmail("123"))
//            .thenCompose(email -> getPassword(email)))
//            .thenAccept(pword -> {
//                System.out.println(pword);
//            });

        var result = getEmail("123")
            .thenCompose(email->getPassword(email))
        .thenAccept(pword->{
            System.out.println(pword);
        });
  }
    public static void main(String[] args) {
        show();
        System.out.println("me");

    }
}
