package com.stan.springbootcourse.dto.request;

import com.stan.springbootcourse.annotations.IsValidPhone;
import lombok.Data;

@Data
public class Student {
    @IsValidPhone
    private String phone;
}
