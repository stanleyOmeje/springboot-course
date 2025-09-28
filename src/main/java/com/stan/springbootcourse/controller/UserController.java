package com.stan.springbootcourse.controller;

import com.stan.springbootcourse.dto.request.CreateUserRequest;
import com.stan.springbootcourse.dto.response.DefaultResponse;
import com.stan.springbootcourse.dto.response.UserResponse;
import com.stan.springbootcourse.entity.Users;
import com.stan.springbootcourse.service.UsersService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/vi/user")
public class UserController {

    private final UsersService usersService;

    @PostMapping
    public ResponseEntity<DefaultResponse<UserResponse>> createUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
        DefaultResponse<UserResponse> defaultResponse = usersService.createUser(createUserRequest);
        return new ResponseEntity<>(defaultResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<DefaultResponse<List<UserResponse>>> getAllUsers(Pageable pageable) {
        DefaultResponse<List<UserResponse>> defaultResponse = usersService.getAllUserUser(pageable);
        return new ResponseEntity<>(defaultResponse, HttpStatus.OK);
    }

}
