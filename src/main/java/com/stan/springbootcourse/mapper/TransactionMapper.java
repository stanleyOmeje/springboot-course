package com.stan.springbootcourse.mapper;

import com.stan.springbootcourse.dto.request.CreateTransactionRequest;
import com.stan.springbootcourse.dto.request.TransactionDto;
import com.stan.springbootcourse.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    Transaction mapTransactionDtoToTransaction(TransactionDto transactionDto);
    TransactionDto mapTransactionToTransactionDto(Transaction transaction);

    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    Transaction mapCreateTransactionRequestToTransaction(CreateTransactionRequest createTransactionRequest);
}
