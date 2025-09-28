package com.stan.springbootcourse.dto.request;

import lombok.Data;

@Data
public class AddressDto {
    private String street;
    private String city;
    private String zip;
}
