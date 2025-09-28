package com.stan.springbootcourse.service;

import com.stan.springbootcourse.dto.request.CreateCategoryRequest;
import com.stan.springbootcourse.dto.request.CreateProfileRequest;
import com.stan.springbootcourse.dto.request.ProfileDto;
import com.stan.springbootcourse.dto.response.CategoryDto;
import com.stan.springbootcourse.dto.response.DefaultResponse;
import com.stan.springbootcourse.entity.Category;
import com.stan.springbootcourse.entity.Profile;

import java.util.List;

public interface ProfileService {

    DefaultResponse<Profile> createProfile(CreateProfileRequest request);
    DefaultResponse<ProfileDto> getProfileById(long id);
    DefaultResponse<List<ProfileDto>> getAllProfile();

    DefaultResponse<ProfileDto> updateProfile(long id, ProfileDto request);
}
