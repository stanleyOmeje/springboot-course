package com.stan.springbootcourse.service.impl;

import com.stan.springbootcourse.dto.request.CreateTransactionRequest;
import com.stan.springbootcourse.dto.request.TransactionDto;
import com.stan.springbootcourse.dto.response.DefaultResponse;
import com.stan.springbootcourse.dto.response.SummaryOutput;
import com.stan.springbootcourse.entity.Transaction;
import com.stan.springbootcourse.mapper.TransactionMapper;
import com.stan.springbootcourse.repository.TransactionRepository;
import com.stan.springbootcourse.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionMapper transactionMapper;
    private final TransactionRepository transactionRepository;

    @Override
    public DefaultResponse<TransactionDto> createTransaction(CreateTransactionRequest request) {
        DefaultResponse<TransactionDto> response = new DefaultResponse<>();
        try {
            log.info("Inside createTransaction with request: {}", request);

            //Transaction transaction = transactionMapper.mapCreateTransactionRequestToTransaction(request);

            Transaction transaction = new Transaction();

            transaction.setAmount( request.getAmount() );
            transaction.setAccountNumber( request.getAccountNumber() );
            transaction.setUserId( request.getUserId() );
            transaction.setProductCode( request.getProductCode() );
            transaction.setCategoryCode( request.getCategoryCode() );
            transaction.setReference( request.getReference() );
            transaction.setReceiptNumber( request.getReceiptNumber() );
            transaction.setPhone( request.getPhone() );

            transaction.setCreatedAt( java.time.LocalDateTime.now() );



            transaction = transactionRepository.save(transaction);
            log.info("Saved transaction is:.. " + transaction);
            TransactionDto transactionDto = transactionMapper.mapTransactionToTransactionDto(transaction);

            response.setStatus("00");
            response.setMessage("Success");
            response.setData(transactionDto);
            log.info("Saved transaction response is:.. " + response);

            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("transaction response is:.. " + response);
        return response;
    }

    @Override
    public DefaultResponse<Map<String, BigDecimal>> getTransactionSummary() {
        log.info("Inside getTransactionSummary");
        DefaultResponse<Map<String, BigDecimal>> response = new DefaultResponse<>();
        try {
            List<Transaction> transactions = transactionRepository.findAll();
            Map<String, BigDecimal> groupedTransaction = transactions.stream().collect(Collectors.groupingBy
                (Transaction::getAccountNumber,
                    Collectors.reducing(BigDecimal.ZERO, Transaction::getAmount, BigDecimal::add)
                )
            );

//            SummaryOutput summaryOutput = transactions.stream().collect(Collectors.groupingBy
//                (Transaction::getUserId,
//                    Transaction::getAccountNumber,
//                    Collectors.reducing(BigDecimal.ZERO, Transaction::getAmount, BigDecimal::add)
//                )
//            );

            response.setStatus("00");
            response.setMessage("Success");
            response.setData(groupedTransaction);
            log.info("Saved transaction response is:.. " + response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
