package com.stan.springbootcourse.service.impl;

import com.stan.springbootcourse.dto.request.AddressDto;
import com.stan.springbootcourse.dto.request.CreateAddressRequest;
import com.stan.springbootcourse.dto.response.DefaultResponse;
import com.stan.springbootcourse.entity.Address;
import com.stan.springbootcourse.entity.Users;
import com.stan.springbootcourse.exceptions.NotFoundException;
import com.stan.springbootcourse.mapper.UserMapper;
import com.stan.springbootcourse.repository.AddressRepository;
import com.stan.springbootcourse.repository.UsersRepository;
import com.stan.springbootcourse.service.AddressService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Slf4j
@Service
public class AddressServiceImpl implements AddressService {
    private final UsersRepository usersRepository;
    private final AddressRepository addressRepository;


    @Override
    public DefaultResponse<List<Address>> createAddress(CreateAddressRequest request) {
        log.info("Inside create address with Create address request: {}", request);
        DefaultResponse<List<Address>> response = new DefaultResponse<>();
        try {
            long userId = request.getUserId();
            if (StringUtils.isEmpty(userId)) {
                throw new IllegalArgumentException("UserId is empty");
            }
            Optional<Users> optionalUsers = usersRepository.findById(userId);
            if (!optionalUsers.isPresent()) {
                throw new NotFoundException("01", "User does exists");
            }
            List<Address> address = UserMapper.mapCreateAddressRequestToAddress(request, optionalUsers.get());
            address = addressRepository.saveAll(address);
            log.info("Saved address is:.. " + address);

            response.setStatus("00");
            response.setMessage("Success");
            response.setData(address);
            log.info("Saved address response is:.. " + response);

            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public DefaultResponse<List<Address>> getAllAddress(Pageable pageable) {
        log.info("Inside getAllAddress");
        DefaultResponse<List<Address>> response = new DefaultResponse<>();
        try {
            List<Address> addresses = addressRepository.findAll();
            if (addresses.isEmpty()) {
                response.setStatus("01");
                response.setMessage("Address is empty");
                return response;
            }
            response.setStatus("00");
            response.setMessage("Success");
            response.setData(addresses);
            log.info("getAllUserUser is:.. " + response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public DefaultResponse<List<Address>> getAddressByUser(long userId) {
        log.info("Inside getAddressByUser with userId: {}", userId);
        DefaultResponse<List<Address>> response = new DefaultResponse<>();
        try {
            if (StringUtils.isEmpty(userId)) {
                throw new IllegalArgumentException("UserId is empty");
            }
            Optional<Users> users = usersRepository.findById(userId);
            if (users.isEmpty()) {
                throw new IllegalArgumentException("User does not exist");
            }
            List<Address> addresses = addressRepository.findByUsers(users.get());
            response.setStatus("00");
            response.setMessage("Success");
            response.setData(addresses);
            log.info("getAddressByUser is:.. " + response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public DefaultResponse<Address> updateAddress(long id, AddressDto request) {
        log.info("Inside updateAddress with id ...{} ... and update address request: {}", id, request);
        DefaultResponse<Address> response = new DefaultResponse<>();
        try {
            Optional<Address> optionalAddress = addressRepository.findById(id);
            if (optionalAddress.isEmpty()) {
                throw new NotFoundException("01", "Address does not exist");
            }
            Address address = optionalAddress.get();
            address.setStreet(request.getStreet());
            address.setCity(request.getCity());
            address.setZip(request.getZip());
            address = addressRepository.save(address);
            response.setStatus("00");
            response.setMessage("Success");
            response.setData(address);
            log.info("getAddressByUser is:.. " + response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

}
