package com.stan.springbootcourse.service;

import com.stan.springbootcourse.dto.request.CreateTransactionRequest;
import com.stan.springbootcourse.dto.request.TransactionDto;
import com.stan.springbootcourse.dto.response.DefaultResponse;

import java.math.BigDecimal;
import java.util.Map;

public interface TransactionService {
    DefaultResponse<TransactionDto> createTransaction(CreateTransactionRequest request);

    DefaultResponse<Map<String, BigDecimal>> getTransactionSummary();

}
