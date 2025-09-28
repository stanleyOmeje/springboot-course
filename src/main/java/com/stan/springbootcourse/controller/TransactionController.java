package com.stan.springbootcourse.controller;

import com.stan.springbootcourse.dto.request.CreateProductRequest;
import com.stan.springbootcourse.dto.request.CreateTransactionRequest;
import com.stan.springbootcourse.dto.request.TransactionDto;
import com.stan.springbootcourse.dto.response.DefaultResponse;
import com.stan.springbootcourse.dto.response.ProductDto;
import com.stan.springbootcourse.service.ProductService;
import com.stan.springbootcourse.service.TransactionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("api/vi/transaction")
public class TransactionController {
    private final TransactionService transactionService;
    @PostMapping
    public ResponseEntity<DefaultResponse<TransactionDto>> createTransaction(@RequestBody @Valid CreateTransactionRequest request) {
        DefaultResponse<TransactionDto> defaultResponse = transactionService.createTransaction(request);
        return new ResponseEntity<>(defaultResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<DefaultResponse<Map<String, BigDecimal>>> getTransactionSummary() {
        DefaultResponse<Map<String, BigDecimal>> defaultResponse = transactionService.getTransactionSummary();
        return new ResponseEntity<>(defaultResponse, HttpStatus.OK);
    }
}
