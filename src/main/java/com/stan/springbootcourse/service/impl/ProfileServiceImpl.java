package com.stan.springbootcourse.service.impl;

import com.stan.springbootcourse.dto.request.CreateProfileRequest;
import com.stan.springbootcourse.dto.request.ProfileDto;
import com.stan.springbootcourse.dto.response.DefaultResponse;
import com.stan.springbootcourse.entity.Profile;
import com.stan.springbootcourse.entity.Users;
import com.stan.springbootcourse.exceptions.NotFoundException;
import com.stan.springbootcourse.repository.ProfileRepository;
import com.stan.springbootcourse.repository.UsersRepository;
import com.stan.springbootcourse.service.ProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class ProfileServiceImpl implements ProfileService {
    private final UsersRepository usersRepository;
    private final ProfileRepository profileRepository;

    @Override
    public DefaultResponse<Profile> createProfile(CreateProfileRequest request) {
        log.info("Inside create profile with Create profile request: {}", request);
        DefaultResponse<Profile> response = new DefaultResponse<>();
        try {
            long userId = request.getUserId();
            if (StringUtils.isEmpty(userId)) {
                throw new IllegalArgumentException("UserId is empty");
            }
            Optional<Users> optionalUsers = usersRepository.findById(userId);
            if (optionalUsers.isEmpty()) {
                throw new NotFoundException("01", "User does exists");
            }
            Profile profile = new Profile();
            profile.setBio(request.getProfileDto().getBio());
            profile.setPhoneNumber(Optional.ofNullable(request.getProfileDto().getPhoneNumber()).orElse(""));
            profile.setDateOfBirth(request.getProfileDto().getDateOfBirth());
            profile.setLocaltyPoints(request.getProfileDto().getLocaltyPoints());
            profile.setUser(optionalUsers.get());

            profile = profileRepository.save(profile);
            log.info("Saved profile is:.. " + profile);

            response.setStatus("00");
            response.setMessage("Success");
            response.setData(profile);
            log.info("Saved profile response is:.. " + response);

            return response;
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public DefaultResponse<ProfileDto> getProfileById(long id) {
        log.info("Inside getProfileById with id: {}", id);
        DefaultResponse<ProfileDto> response = new DefaultResponse<>();
        try {
            if (StringUtils.isEmpty(id)) {
                throw new IllegalArgumentException("id is empty");
            }
            Optional<Profile> optionalProfile = profileRepository.findById(id);
            if (optionalProfile.isPresent()) {
                ProfileDto profileDto = new ProfileDto();
                profileDto.setBio(optionalProfile.get().getBio());
                profileDto.setPhoneNumber(optionalProfile.get().getPhoneNumber());
                profileDto.setDateOfBirth(optionalProfile.get().getDateOfBirth());
                profileDto.setLocaltyPoints(optionalProfile.get().getLocaltyPoints());
                response.setStatus("00");
                response.setMessage("Success");
                response.setData(profileDto);
            }
            log.info("getProfileById response is:.. " + response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public DefaultResponse<List<ProfileDto>> getAllProfile() {
        log.info("Inside getAllProfile");
        DefaultResponse<List<ProfileDto>> response = new DefaultResponse<>();
        try {
            List<Profile> profileList = profileRepository.findAll();
            if (!profileList.isEmpty()) {
                List<ProfileDto> profileDtoList = profileList.stream().map(profile -> {
                    ProfileDto profileDto = new ProfileDto();
                    profileDto.setBio(profile.getBio());
                    profileDto.setPhoneNumber(profile.getPhoneNumber());
                    profileDto.setDateOfBirth(profile.getDateOfBirth());
                    profileDto.setLocaltyPoints(profile.getLocaltyPoints());
                    return profileDto;
                }).toList();

                response.setStatus("00");
                response.setMessage("Success");
                response.setData(profileDtoList);
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
    public DefaultResponse<ProfileDto> updateProfile(long id, ProfileDto request) {
        log.info("Inside updateProfile with id ...{} ... and updateProfile request: {}", id, request);
        DefaultResponse<ProfileDto> response = new DefaultResponse<>();
        try {
            Optional<Profile> optionalProfile = profileRepository.findById(id);
            if (optionalProfile.isEmpty()) {
                throw new NotFoundException("01", "Profile does not exist");
            }
            Profile profile = optionalProfile.get();
            profile.setBio(request.getBio());
            profile.setPhoneNumber(request.getPhoneNumber());
            profile.setDateOfBirth(request.getDateOfBirth());
            profile.setLocaltyPoints(request.getLocaltyPoints());
            profile = profileRepository.save(profile);

            ProfileDto profileDto = new ProfileDto();
            profileDto.setBio(profile.getBio());
            profileDto.setPhoneNumber(profile.getPhoneNumber());
            profileDto.setDateOfBirth(profile.getDateOfBirth());
            profileDto.setLocaltyPoints(profile.getLocaltyPoints());

            response.setStatus("00");
            response.setMessage("Success");
            response.setData(profileDto);
            log.info("updateProfile response is:.. " + response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
