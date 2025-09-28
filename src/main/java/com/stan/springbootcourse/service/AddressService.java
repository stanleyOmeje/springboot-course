package com.stan.springbootcourse.service;

import com.stan.springbootcourse.dto.request.AddressDto;
import com.stan.springbootcourse.dto.request.CreateAddressRequest;
import com.stan.springbootcourse.dto.response.DefaultResponse;
import com.stan.springbootcourse.entity.Address;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AddressService {
    DefaultResponse<List<Address>> createAddress(CreateAddressRequest request);

    DefaultResponse<List<Address>> getAllAddress(Pageable pageable);

    DefaultResponse<List<Address>> getAddressByUser(long userId);

    DefaultResponse<Address> updateAddress(long id, AddressDto request);
}
