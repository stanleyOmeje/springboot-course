package com.stan.springbootcourse.mapper;

import com.stan.springbootcourse.dto.request.CreateCategoryRequest;
import com.stan.springbootcourse.dto.response.CategoryDto;
import com.stan.springbootcourse.entity.Category;

public class CategoryMapper {
    public static Category mapCreateCategoryRequestToCategory(CreateCategoryRequest request){
        Category category = new Category();
        category.setCategoryCode(request.getCode());
        category.setCategoryName(request.getName());
        category.setCategoryDescription(request.getDescription());
        return category;
    }

    public static CategoryDto mapCategoryToCategoryDto(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCode(category.getCategoryCode());
        categoryDto.setName(category.getCategoryName());
        categoryDto.setDescription(category.getCategoryDescription());
        return categoryDto;
    }
}
