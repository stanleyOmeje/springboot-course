package com.stan.springbootcourse.controller;

import com.stan.springbootcourse.dto.request.AddressDto;
import com.stan.springbootcourse.dto.request.CreateAddressRequest;
import com.stan.springbootcourse.dto.response.DefaultResponse;
import com.stan.springbootcourse.entity.Address;
import com.stan.springbootcourse.service.AddressService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/vi/address")
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<DefaultResponse<List<Address>>> createAddress(@RequestBody @Valid CreateAddressRequest request) {
        DefaultResponse<List<Address>> defaultResponse = addressService.createAddress(request);
        return new ResponseEntity<>(defaultResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<DefaultResponse<List<Address>>> getAllAddress(Pageable pageable) {
        DefaultResponse<List<Address>> defaultResponse = addressService.getAllAddress(pageable);
        return new ResponseEntity<>(defaultResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse<List<Address>>> getAAddressByUser(@PathVariable("id") long userId) {
        DefaultResponse<List<Address>> defaultResponse = addressService.getAddressByUser(userId);
        return new ResponseEntity<>(defaultResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse<Address>> updateAddress(@PathVariable("id") long id,@RequestBody @Valid AddressDto request) {
        DefaultResponse<Address> defaultResponse = addressService.updateAddress(id, request);
        return new ResponseEntity<>(defaultResponse, HttpStatus.OK);
    }
}
