package com.stan.springbootcourse.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    @JsonIgnoreProperties(value = {"users"}, allowSetters = true)
    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @Builder.Default
    private List<Address> address = new ArrayList<>();

    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private Profile profile;

    public void addAddress(Address address) {
        this.address.add(address);
        address.setUsers(this);
    }

}
