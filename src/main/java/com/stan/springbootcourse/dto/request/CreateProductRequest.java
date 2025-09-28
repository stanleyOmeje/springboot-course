package com.stan.springbootcourse.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateProductRequest {
    @NotBlank
    private String code;
    private String name;
    private String description;
    private BigDecimal price;
    @NotBlank
    private String categoryCode;
}
