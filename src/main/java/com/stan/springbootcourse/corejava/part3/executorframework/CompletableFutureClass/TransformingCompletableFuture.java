package com.stan.springbootcourse.corejava.part3.executorframework.CompletableFutureClass;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class TransformingCompletableFuture {
    public static String getName(String name){
        return name;
    }

    public static String convetName(String name){
        return name.toUpperCase();
    }

    public static void showName(){
        var future =CompletableFuture.supplyAsync(()-> getName("Stan"));
        try{
            var result = future.thenApply(TransformingCompletableFuture::convetName)
                .get();
            System.out.println("SHOWNAME:: "+result);
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }

    }

    public static String sendName(){
        var future =CompletableFuture.supplyAsync(()-> getName("Stan"));
        try{
            return future.thenApply(TransformingCompletableFuture::convetName)
                .get();
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
        return null;
    }

    public static CompletableFuture<String> sendCompName(){
        var future =CompletableFuture.supplyAsync(()-> getName("Stan"));
        return future.thenApply(TransformingCompletableFuture::convetName);
    }

    public static void main(String[] args) {
        showName();
        String sendName = sendName();
        System.out.println("SENDNAME:: " + sendName);
    }
}
