package com.stan.springbootcourse.service.impl;

import com.stan.springbootcourse.dto.request.CreateUserRequest;
import com.stan.springbootcourse.dto.response.DefaultResponse;
import com.stan.springbootcourse.dto.response.UserResponse;
import com.stan.springbootcourse.entity.Address;
import com.stan.springbootcourse.entity.Profile;
import com.stan.springbootcourse.entity.Users;
import com.stan.springbootcourse.mapper.UserMapper;
import com.stan.springbootcourse.repository.AddressRepository;
import com.stan.springbootcourse.repository.ProfileRepository;
import com.stan.springbootcourse.repository.UsersRepository;
import com.stan.springbootcourse.service.UsersService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Slf4j
@Service
public class UserServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    private final AddressRepository addressRepository;
    private final ProfileRepository profileRepository;

    @Transactional
    @Override
    public DefaultResponse<UserResponse> createUser(CreateUserRequest createUserRequest) {
        log.info("Inside createUser with request: {}", createUserRequest);
        DefaultResponse<UserResponse> response = new DefaultResponse<>();
        try {
            String email = createUserRequest.getEmail();
            if (StringUtils.isEmpty(email)) {
                throw new IllegalArgumentException("Email is empty");
            }
            Optional<Users> optionalUsers = usersRepository.findByEmail(email);
            if (optionalUsers.isPresent()) {
                throw new IllegalArgumentException("Email already exists");
            }
            Users users = UserMapper.mapCreateUserRequestToUsers(createUserRequest);
            users = usersRepository.save(users);
            log.info("Saved user is:.. " + users);

            Address address = UserMapper.mapCreateUserRequestToAddress(createUserRequest, users);
            address = addressRepository.save(address);
            log.info("Saved address is:.. " + address);

            Profile profile = UserMapper.mapCreateUserRequestToProfile(createUserRequest, users);
            profile = profileRepository.save(profile);
            log.info("Saved profile is:.. " + profile);

            UserResponse userResponse = new UserResponse();
            userResponse.setUsers(users);
            userResponse.addAddress(address);
            userResponse.setProfile(profile);

            response.setStatus("00");
            response.setMessage("Success");
            response.setData(userResponse);
            log.info("Saved user with address and profile is:.. " + userResponse);

            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public DefaultResponse<List<UserResponse>> getAllUserUser(Pageable pageable) {
        log.info("Inside getAllUserUser");
        DefaultResponse<List<UserResponse>> response = new DefaultResponse<>();
        try {
            List<Users> users = usersRepository.findAll();
            List<UserResponse> userResponses = new ArrayList<>();
            if (!users.isEmpty()) {
                users.forEach(user -> {
                    UserResponse userResponse = new UserResponse();
                    userResponse.setUsers(user);
                    List<Address> addresses = addressRepository.findByUsers(user);
                    if (!addresses.isEmpty()) {
                        addresses.forEach(address -> {
                            userResponse.addAddress(address);
                        });
                    }
                    Profile profile = profileRepository.findByUser(user).orElse(null);
                    userResponse.setProfile(profile);
                    userResponses.add(userResponse);
                });
                response.setStatus("00");
                response.setMessage("Success");
                response.setData(userResponses);
            }
            log.info("getAllUserUser is:.. " + response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
