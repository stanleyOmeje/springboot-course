package com.stan.springbootcourse.corejava.part3;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureAsync {
    @SneakyThrows
    public static void main(String[] args)  {
       var future = CompletableFuture.supplyAsync(() -> 200.0);
       future
            .thenApply(CompletableFutureAsync::getFarinheit)
            .thenAccept(System.out::println);

       System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("Getting PlayList");
       var future1 = CompletableFuture.supplyAsync(CompletableFutureAsync::getEmail);
       future1.
           thenCompose(email->CompletableFuture.supplyAsync(CompletableFutureAsync::getPlayList))
           .thenAccept(System.out::println);

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("Getting PlayList From method");
        System.out.println(getEmailAsync().get(0));
    }

    public static double getFarinheit(double c) {
        return c + 32;
    }

    public static List<String> getEmailAsync() throws ExecutionException, InterruptedException {
         var future = CompletableFuture.supplyAsync(CompletableFutureAsync::getEmail)
                 .thenCompose(email->CompletableFuture.supplyAsync(()->CompletableFutureAsync.getPlayList(email)));
            //.thenApply(playList->playList)
           // .thenAccept(System.out::println);
        return future.get();
    }

    public static String getEmail(){
        return "stan.com";
    }
    public static List<String> getPlayList() {
        List<String> list = new ArrayList<>();
        list.add("R Kelly");
        list.add("2 face");
        list.add("Nice");
        list.add("Boby brown");
        return list;
    }

    public static List<String> getPlayList(String email) {
        List<String> list = new ArrayList<>();
        list.add("R Kelly");
        list.add("2 face");
        list.add("Nice");
        list.add("Boby brown");
        return list;
    }

    public static List<String> getPlayListFromCompletable(CompletableFuture<String> completableFuture){
        List<String> list = new ArrayList<>();
        completableFuture.thenAccept(playList->{
            list.add(playList);
        });
        return list;
    }
}
