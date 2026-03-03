package com.stan.springbootcourse.corejava.part3.executorframework.CompletableFutureClass.quoteexercise;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class QuoteService {
    CompletableFuture<Quote> getQuote(String site) {
        Random random = new Random();
        var quote = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100 + random.nextInt(100));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            double randomPrice = random.nextDouble(100);
            BigDecimal price = BigDecimal.valueOf(1000 + randomPrice);
            return new Quote(site, price);
        });
        return quote;
    }

    List<CompletableFuture<Quote>> getAllQuotes() {

        List<String> sites = List.of("site1", "site2", "site3", "site4");

        return sites
            .stream()
            .map(this::getQuote).toList();
    }

    public static void show() {

        var t1 = LocalTime.now();
        System.out.println("::: Qerying website :::");
        QuoteService quoteService = new QuoteService();
        quoteService.getQuote("site1").thenAccept(System.out::println);

        System.out.println("::::::::::::::::::::::::::::::::::::::");
        var allQuotes = quoteService.getAllQuotes().stream()
            .map(future -> future.thenAccept(System.out::println))
            .toList();

        var allT = CompletableFuture.allOf(allQuotes.toArray(new CompletableFuture[0]));
        allT.thenRun(() -> {
            var t2 = LocalTime.now();
            Duration duration = Duration.between(t1, t2);
            System.out.println("::: Qerying website  took ::: " + duration.toMillis() + "Msec");
        });

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        show();
        Thread.sleep(1000);

    }
}
