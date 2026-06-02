package com.stan.springbootcourse.corejava.part3.executorservice;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Transactions {
    private long id;
    private String reference;
    private BigDecimal amount;
    private Date date;
    private String productCode;
}
