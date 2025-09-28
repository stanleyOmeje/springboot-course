package com.stan.springbootcourse.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stan.springbootcourse.annotations.IsValidPhone;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateTransactionRequest {
    private BigDecimal amount;
    private String accountNumber;
    @JsonIgnore
    private String userId;
    private String productCode;
    private String categoryCode;
    private String reference;
    private String receiptNumber;
    @IsValidPhone
    private String phone;
}
