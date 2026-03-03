package com.stan.springbootcourse.corejava.part3.executorframework.CompletableFutureClass.quoteexercise;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Quote {
    private String site;
    private BigDecimal price;

    public Quote(String site, BigDecimal price) {
        this.site = site;
        this.price = price;
    }
}
