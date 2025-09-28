package com.stan.springbootcourse.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProfileDto {
    private String bio;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private int localtyPoints;
}
