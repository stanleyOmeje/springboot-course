package com.stan.springbootcourse.dto.response;

import com.stan.springbootcourse.entity.Address;
import com.stan.springbootcourse.entity.Products;
import com.stan.springbootcourse.entity.Profile;
import com.stan.springbootcourse.entity.Users;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserResponse {
//    private String status;
//    private String message;
    private Users users;
    private List<Address> addressList = new ArrayList<>();
    private Profile profile;

    public void addAddress(Address address) {
       addressList.add(address);
    }
}
