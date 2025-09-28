package com.stan.springbootcourse.repository;

import com.stan.springbootcourse.entity.Profile;
import com.stan.springbootcourse.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByUser(Users user);
}
