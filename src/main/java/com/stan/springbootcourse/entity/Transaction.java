package com.stan.springbootcourse.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stan.springbootcourse.annotations.IsValidPhone;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

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
    private LocalDateTime createdAt;
    private Date updatedAt;
    @IsValidPhone
    private String phone;

}
