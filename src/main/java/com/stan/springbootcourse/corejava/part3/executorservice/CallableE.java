package com.stan.springbootcourse.corejava.part3.executorservice;

import jakarta.validation.constraints.Future;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.*;

public class CallableE {
    public Transactions getTransactions() {
        Transactions transactions = new Transactions();
        transactions.setId(1);
        transactions.setAmount(BigDecimal.valueOf(1000));
        transactions.setReference("CA123");
        transactions.setDate(new Date());
        transactions.setProductCode("coke");
        return transactions;
    }

    public Transactions createTransactions() throws InterruptedException {
        LongRunningTask.doJob();
        return getTransactions();
    }

    public void executingTransactions() throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            var future = executor.submit(() -> {
                return createTransactions();
            });
            System.out.println("Do other job");
            Transactions transactions = future.get();
            System.out.println(transactions);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }


    }

    public Transactions printingTransactions() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        try {
            var f = executor.submit(this::createTransactions);
            return f.get(4000, TimeUnit.MILLISECONDS);
        } catch (TimeoutException | ExecutionException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            executor.shutdown();
        }
    }

    public CompletableFuture<Transactions> printingTransactionsAsync(){
        return CompletableFuture.supplyAsync(()-> {
            try {
                return printingTransactions();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CallableE cal = new CallableE();
        cal.executingTransactions();
        // System.out.println(cal.createTransactions());
        //System.out.println("Printing Transaction:: " + cal.printingTransactions());
        CompletableFuture<Transactions> result = cal.printingTransactionsAsync();
        result.thenAccept(c->System.out.println("printingTransactionsAsync Accept:: " + c));
        System.out.println("printingTransactionsAsync Transaction:: " + cal.printingTransactionsAsync().get());
        Thread.sleep(5000);
    }
}
