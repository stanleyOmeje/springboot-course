package com.stan.springbootcourse.controller;

import com.stan.springbootcourse.dto.request.CreateCategoryRequest;
import com.stan.springbootcourse.dto.request.CreateProductRequest;
import com.stan.springbootcourse.dto.response.DefaultResponse;
import com.stan.springbootcourse.dto.response.ProductDto;
import com.stan.springbootcourse.entity.Category;
import com.stan.springbootcourse.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/vi/product")
public class ProductController {
    private final ProductService productService;
    @PostMapping
    public ResponseEntity<DefaultResponse<ProductDto>> createProduct(@RequestBody @Valid CreateProductRequest request) {
        DefaultResponse<ProductDto> defaultResponse = productService.createProduct(request);
        return new ResponseEntity<>(defaultResponse, HttpStatus.OK);
    }

    @PutMapping("/{code}")
    public ResponseEntity<DefaultResponse<ProductDto>> updateProduct(@PathVariable("code") String code, @RequestBody @Valid CreateProductRequest request) {
        DefaultResponse<ProductDto> defaultResponse = productService.updateProduct(code, request);
        return new ResponseEntity<>(defaultResponse, HttpStatus.OK);
    }
}
