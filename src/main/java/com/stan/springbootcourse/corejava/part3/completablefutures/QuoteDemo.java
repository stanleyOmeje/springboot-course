package com.stan.springbootcourse.corejava.part3.completablefutures;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class QuoteDemo {
    public static BigDecimal show() throws ExecutionException, InterruptedException {
        var v1 = CompletableFuture.supplyAsync(()->{
            return new Quote("site1", BigDecimal.valueOf(5000));
        });
        var v2 = CompletableFuture.supplyAsync(()->{
            return new Quote("site2", BigDecimal.valueOf(2000));
        });
        var v3 = CompletableFuture.supplyAsync(()->{
            return new Quote("site3", BigDecimal.valueOf(3000));
        });
        var r = CompletableFuture.allOf(v1, v2, v3);

        BigDecimal m1 = v1.get().getAmount();
        BigDecimal m2 = v2.get().getAmount();
        BigDecimal m3 = v3.get().getAmount();

        BigDecimal mAmount = min(m1,m2,m3);
        return mAmount;

    }

    public static BigDecimal min(BigDecimal a, BigDecimal b, BigDecimal c) {
        return a.min(b).min(c);
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.print("The min amount is : ");
        System.out.println(show());
    }
}
