package com.stan.springbootcourse.corejava.part3;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CombiningTask {
    public static BigDecimal getWage() throws ExecutionException, InterruptedException {
        var wages = CompletableFuture
            .supplyAsync(() -> "100$" )
            .thenApply(s -> {
                var p = s.replace("$","");
               double d = Double.parseDouble(p);
               return BigDecimal.valueOf(d);
            });
          return wages.get();
    }

    public static int getHourWork(int hourWork){
        return hourWork;
    }

    public static BigDecimal getSalary() throws ExecutionException, InterruptedException {
        return CombiningTask.getWage()
            .multiply(BigDecimal.valueOf(getHourWork(8)));

    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        var wages = CompletableFuture
            .supplyAsync(() -> "100$" )
            .thenApply(s -> new BigDecimal(s.replace("$","")));

        var hourWork = CompletableFuture.supplyAsync(()->8);

         wages
            .thenCombine(hourWork, (price, rate)-> price.multiply(BigDecimal.valueOf(rate)))
             .thenAccept(System.out::println);


    }
}
