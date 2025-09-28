package com.stan.springbootcourse.dto.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CreateProfileRequest {
    private long userId;
    ProfileDto profileDto;
}
