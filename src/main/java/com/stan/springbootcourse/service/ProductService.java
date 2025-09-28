package com.stan.springbootcourse.service;

import com.stan.springbootcourse.dto.request.CreateCategoryRequest;
import com.stan.springbootcourse.dto.request.CreateProductRequest;
import com.stan.springbootcourse.dto.response.DefaultResponse;
import com.stan.springbootcourse.dto.response.ProductDto;
import com.stan.springbootcourse.entity.Category;

public interface ProductService {
    DefaultResponse<ProductDto> createProduct(CreateProductRequest request);

    DefaultResponse<ProductDto> updateProduct(String code, CreateProductRequest request);
}
