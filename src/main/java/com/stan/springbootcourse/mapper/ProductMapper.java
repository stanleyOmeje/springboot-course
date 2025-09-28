package com.stan.springbootcourse.mapper;

import com.stan.springbootcourse.dto.request.CreateProductRequest;
import com.stan.springbootcourse.dto.response.ProductDto;
import com.stan.springbootcourse.entity.Category;
import com.stan.springbootcourse.entity.Products;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "category", expression = "java(category)")
    Products productDtoToProduct(CreateProductRequest productDto, Category category);
    @Mapping(target = "categoryCode", expression = "java(category.getCategoryCode())")
    ProductDto productToProductDto(Products products, Category category);
}
