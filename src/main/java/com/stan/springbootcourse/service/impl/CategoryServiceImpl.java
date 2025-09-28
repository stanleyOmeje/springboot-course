package com.stan.springbootcourse.service.impl;

import com.stan.springbootcourse.dto.request.CreateCategoryRequest;
import com.stan.springbootcourse.dto.response.CategoryDto;
import com.stan.springbootcourse.dto.response.DefaultResponse;
import com.stan.springbootcourse.entity.Address;
import com.stan.springbootcourse.entity.Category;
import com.stan.springbootcourse.exceptions.AlreadyExistException;
import com.stan.springbootcourse.exceptions.NotFoundException;
import com.stan.springbootcourse.mapper.CategoryMapper;
import com.stan.springbootcourse.repository.CategoryRepository;
import com.stan.springbootcourse.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public DefaultResponse<Category> createCategory(CreateCategoryRequest request) {
        log.info("Inside createCategory with request: {}", request);
        DefaultResponse<Category> response = new DefaultResponse<>();
        String categoryCode = request.getCode();
        if (StringUtils.isEmpty(categoryCode)) {
            throw new IllegalArgumentException("categoryCode is empty");
        }
        Optional<Category> optionalCategory = categoryRepository.findCategoryByCategoryCode(categoryCode);
        if (optionalCategory.isPresent()) {
            throw new AlreadyExistException("01", "User Already exists");
        }
        Category category = CategoryMapper.mapCreateCategoryRequestToCategory(request);
        category = categoryRepository.save(category);
        log.info("Saved category is:.. " + category);

        response.setStatus("00");
        response.setMessage("Success");
        response.setData(category);
        log.info("Saved category response is:.. " + response);

        return response;
    }

    @Override
    public DefaultResponse<CategoryDto> getCategoryByCode(String code) {
        log.info("Inside getCategoryByCode with code: {}", code);
        DefaultResponse<CategoryDto> response = new DefaultResponse<>();
        try {
            if (StringUtils.isEmpty(code)) {
                throw new IllegalArgumentException("code is empty");
            }
            Optional<Category> optionalCategory = categoryRepository.findCategoryByCategoryCode(code);
            if (optionalCategory.isPresent()) {
                CategoryDto categoryDto = CategoryMapper.mapCategoryToCategoryDto(optionalCategory.get());
                response.setStatus("00");
                response.setMessage("Success");
                response.setData(categoryDto);
            }
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public DefaultResponse<List<CategoryDto>> getAllCategory() {
        log.info("Inside getAllCategory");
        DefaultResponse<List<CategoryDto>> response = new DefaultResponse<>();
        try {
            List<Category> categories = categoryRepository.findAll();
            if (!categories.isEmpty()) {
                List<CategoryDto> categoryDtoList = categories.stream().map(category -> {
                    CategoryDto categoryDto = CategoryMapper.mapCategoryToCategoryDto(category);
                    return categoryDto;
                }).toList();

                response.setStatus("00");
                response.setMessage("Success");
                response.setData(categoryDtoList);
            }
            log.info("getAllCategory is:.. " + response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("getAllCategory response is:.. " + response);
        return response;
    }

    @Override
    public DefaultResponse<Category> updateCategory(String code, CreateCategoryRequest request) {
        log.info("Inside updateCategory with code ...{} ... and update address request: {}", code, request);
        DefaultResponse<Category> response = new DefaultResponse<>();
        Optional<Category> optionalCategory = categoryRepository.findCategoryByCategoryCode(code);
        if (optionalCategory.isEmpty()) {
            throw new NotFoundException("01", "Category does not exist");
        }
        Category category = optionalCategory.get();
        category.setCategoryName(request.getName());
        category.setCategoryDescription(request.getDescription());


        category = categoryRepository.save(category);
        response.setStatus("00");
        response.setMessage("Success");
        response.setData(category);
        log.info("Updated category is:.. " + response);
        return response;
    }
}
