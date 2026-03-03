package com.stan.springbootcourse.corejava.part3.executorframework;

import com.stan.springbootcourse.corejava.part3.executorframework.util.AsyncUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class CompletableFuterClass {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(()->{
           try {
              AsyncUtil.doJob();
           }catch (Exception e){
               e.printStackTrace();
           }
        }).exceptionally(throwable -> {
          log.info("Inside Async Exception");
          return null;
        });
        Thread.sleep(1000);
    }
}
