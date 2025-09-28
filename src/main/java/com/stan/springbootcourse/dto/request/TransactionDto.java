package com.stan.springbootcourse.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionDto {
    private String responseMessage;
    private String responseCode;
    private String status;
    private BigDecimal amount;
    private String accountNumber;
    @JsonIgnore
    private String userId;
    private String productCode;
    private String categoryCode;
    private String reference;
    private String receiptNumber;
    private String phone;
}
