package com.stan.springbootcourse.dto.request;

import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
public class CreateCategoryRequest {
    private String code;
    private String name;
    private String description;
}
