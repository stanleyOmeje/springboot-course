package com.stan.springbootcourse.repository;

import com.stan.springbootcourse.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
