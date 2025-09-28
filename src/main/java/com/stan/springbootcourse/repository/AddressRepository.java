package com.stan.springbootcourse.repository;

import com.stan.springbootcourse.entity.Address;
import com.stan.springbootcourse.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByUsers(Users users);
}
