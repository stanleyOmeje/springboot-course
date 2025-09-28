package com.stan.springbootcourse.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CreateUserRequest {
    private String name;
    @NotBlank
    private String email;
    private String password;

    private String street;
    private String city;
    private String zip;

    private String bio;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private int localtyPoints;

    private String productName;
    private String productDescription;
    private BigDecimal price;
}
