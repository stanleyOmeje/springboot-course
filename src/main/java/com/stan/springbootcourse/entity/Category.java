package com.stan.springbootcourse.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String categoryCode;
    private String categoryName;
    private String categoryDescription;

    @JsonIgnore
    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
    private Set<Products> products = new HashSet<>();
}
