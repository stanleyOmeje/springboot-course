package com.stan.springbootcourse.service;

import com.stan.springbootcourse.dto.request.CreateUserRequest;
import com.stan.springbootcourse.dto.response.DefaultResponse;
import com.stan.springbootcourse.dto.response.UserResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UsersService {
    DefaultResponse<UserResponse> createUser(CreateUserRequest createUserRequest);
    DefaultResponse<List<UserResponse>> getAllUserUser(Pageable pageable);



}
