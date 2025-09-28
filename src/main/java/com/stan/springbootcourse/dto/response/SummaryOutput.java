package com.stan.springbootcourse.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SummaryOutput {
    private String userId;
    private String accountNumber;
    private BigDecimal sum;
}
