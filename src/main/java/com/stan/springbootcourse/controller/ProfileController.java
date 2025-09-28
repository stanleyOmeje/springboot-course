package com.stan.springbootcourse.controller;

import com.stan.springbootcourse.dto.request.CreateCategoryRequest;
import com.stan.springbootcourse.dto.request.CreateProfileRequest;
import com.stan.springbootcourse.dto.request.ProfileDto;
import com.stan.springbootcourse.dto.response.CategoryDto;
import com.stan.springbootcourse.dto.response.DefaultResponse;
import com.stan.springbootcourse.entity.Category;
import com.stan.springbootcourse.entity.Profile;
import com.stan.springbootcourse.service.CategoryService;
import com.stan.springbootcourse.service.ProfileService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/vi/profile")
public class ProfileController {
    private final ProfileService profileService;

    @PostMapping
    public ResponseEntity<DefaultResponse<Profile>> createProfile(@RequestBody @Valid CreateProfileRequest request) {
        DefaultResponse<Profile> defaultResponse = profileService.createProfile(request);
        return new ResponseEntity<>(defaultResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse<ProfileDto>> getAllProfileById(@PathVariable("id") long id) {
        DefaultResponse<ProfileDto> defaultResponse = profileService.getProfileById(id);
        return new ResponseEntity<>(defaultResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<DefaultResponse<List<ProfileDto>>> getAllProfiles() {
        DefaultResponse<List<ProfileDto>> defaultResponse = profileService.getAllProfile();
        return new ResponseEntity<>(defaultResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse<ProfileDto>> updateProfile(@PathVariable("id")long id, @RequestBody @Valid ProfileDto request) {
        DefaultResponse<ProfileDto> defaultResponse = profileService.updateProfile(id, request);
        return new ResponseEntity<>(defaultResponse, HttpStatus.OK);
    }

}
