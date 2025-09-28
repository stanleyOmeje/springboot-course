package com.stan.springbootcourse.mapper;

import com.stan.springbootcourse.dto.request.CreateAddressRequest;
import com.stan.springbootcourse.dto.request.CreateUserRequest;
import com.stan.springbootcourse.entity.Address;
import com.stan.springbootcourse.entity.Products;
import com.stan.springbootcourse.entity.Profile;
import com.stan.springbootcourse.entity.Users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class UserMapper {
    public static Users mapCreateUserRequestToUsers(CreateUserRequest createUserRequest){
        Users users = new Users();
        users.setEmail(createUserRequest.getEmail());
        users.setPassword(createUserRequest.getPassword());
        users.setName(createUserRequest.getName());
        return users;
    }

    public static Address mapCreateUserRequestToAddress(CreateUserRequest createUserRequest, Users users){
        Address address = new Address();
        address.setCity(createUserRequest.getCity());
        address.setStreet(createUserRequest.getStreet());
        address.setZip(createUserRequest.getZip());
        address.setUsers(users);
        return address;
    }

    public static Profile mapCreateUserRequestToProfile(CreateUserRequest createUserRequest, Users users){
        Profile profile = new Profile();
        profile.setBio(createUserRequest.getBio());
        profile.setPhoneNumber(createUserRequest.getPhoneNumber());
        profile.setDateOfBirth(createUserRequest.getDateOfBirth());
        profile.setLocaltyPoints(createUserRequest.getLocaltyPoints());
        profile.setUser(users);
        return profile;
    }

    public static Products mapCreateUserRequestToProducts(CreateUserRequest createUserRequest){
        Products products = new Products();
        products.setName(createUserRequest.getName());
        products.setDescription("Premium");
        products.setPrice(createUserRequest.getPrice());
        return products;
    }

    public static List<Address> mapCreateAddressRequestToAddress(CreateAddressRequest request, Users users){
        List<Address> addressList = new ArrayList<>();
       return request.getAddresses().stream().map(addressDto->{
            Address address = new Address();
            address.setCity(addressDto.getCity());
            address.setStreet(addressDto.getStreet());
            address.setZip(addressDto.getZip());
            address.setUsers(users);
            return address;
        }).toList();
    }
}
