package com.stan.springbootcourse.repository;

import com.stan.springbootcourse.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String name);
    Optional<Users> findById(long userId);
}
