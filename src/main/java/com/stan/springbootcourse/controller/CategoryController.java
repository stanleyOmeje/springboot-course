package com.stan.springbootcourse.controller;

import com.stan.springbootcourse.dto.request.CreateCategoryRequest;
import com.stan.springbootcourse.dto.response.CategoryDto;
import com.stan.springbootcourse.dto.response.DefaultResponse;
import com.stan.springbootcourse.entity.Category;
import com.stan.springbootcourse.service.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/vi/category")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<DefaultResponse<Category>> createCategory(@RequestBody @Valid CreateCategoryRequest request) {
        DefaultResponse<Category> defaultResponse = categoryService.createCategory(request);
        return new ResponseEntity<>(defaultResponse, HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<DefaultResponse<CategoryDto>> getACategoryByCode(@PathVariable("code") String code) {
        DefaultResponse<CategoryDto> defaultResponse = categoryService.getCategoryByCode(code);
        return new ResponseEntity<>(defaultResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<DefaultResponse<List<CategoryDto>>> getAllCategories() {
        DefaultResponse<List<CategoryDto>> defaultResponse = categoryService.getAllCategory();
        return new ResponseEntity<>(defaultResponse, HttpStatus.OK);
    }

    @PutMapping("/{code}")
    public ResponseEntity<DefaultResponse<Category>> updateCategory(@PathVariable("code")String code, @RequestBody @Valid CreateCategoryRequest request) {
        DefaultResponse<Category> defaultResponse = categoryService.updateCategory(code, request);
        return new ResponseEntity<>(defaultResponse, HttpStatus.OK);
    }

}
