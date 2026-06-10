package com.stan.springbootcourse.corejava.part3.completablefutures;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Quote {
    private String site;
    private BigDecimal amount;

    public Quote(String site, BigDecimal amount) {
        this.site = site;
        this.amount = amount;
    }
}
