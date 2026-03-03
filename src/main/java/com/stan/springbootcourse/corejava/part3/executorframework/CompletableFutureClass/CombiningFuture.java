package com.stan.springbootcourse.corejava.part3.executorframework.CompletableFutureClass;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CombiningFuture {

    public static BigDecimal getPrice(){
        return BigDecimal.valueOf(50000);
    }

    public static double getRate(){
        return 2.5;
    }

    public static CompletableFuture<BigDecimal> getFuturePrice(){
        return CompletableFuture.supplyAsync(CombiningFuture::getPrice);
    }


    public static CompletableFuture<Double> getFutureRate(){
        return CompletableFuture.supplyAsync(CombiningFuture::getRate);
    }

   public static CompletableFuture<BigDecimal> computeAmount() throws ExecutionException, InterruptedException {
       var futurePrice = getFuturePrice();
        var futureRate = getFutureRate();
        var result = futurePrice
            .thenCombine(futureRate,
                (price, rate)-> price.multiply(BigDecimal.valueOf(rate))
            );
        System.out.println(result.get());
        return result;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        computeAmount();
    }
}
