package com.stan.springbootcourse.service;

import com.stan.springbootcourse.dto.request.CreateCategoryRequest;
import com.stan.springbootcourse.dto.response.CategoryDto;
import com.stan.springbootcourse.dto.response.DefaultResponse;
import com.stan.springbootcourse.entity.Category;

import java.util.List;

public interface CategoryService {

    DefaultResponse<Category> createCategory(CreateCategoryRequest request);
    DefaultResponse<CategoryDto> getCategoryByCode(String code);
    DefaultResponse<List<CategoryDto>> getAllCategory();

    DefaultResponse<Category> updateCategory(String code, CreateCategoryRequest request);
}
