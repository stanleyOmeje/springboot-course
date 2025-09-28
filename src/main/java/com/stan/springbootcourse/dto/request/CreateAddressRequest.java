package com.stan.springbootcourse.dto.request;

import com.stan.springbootcourse.entity.Users;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
public class CreateAddressRequest {
    private long userId;
    List<AddressDto> addresses;
}
