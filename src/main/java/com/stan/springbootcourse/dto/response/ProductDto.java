package com.stan.springbootcourse.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {
    private String code;
    private String name;
    private String description;
    private BigDecimal price;
    private String categoryCode;
}
