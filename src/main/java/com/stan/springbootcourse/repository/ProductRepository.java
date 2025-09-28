package com.stan.springbootcourse.repository;

import com.stan.springbootcourse.dto.response.ProductDto;
import com.stan.springbootcourse.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
    Optional<Products> findProductByCode(String code);
}
