package com.stan.springbootcourse.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String bio;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private int localtyPoints;

    @MapsId
    @OneToOne
    @JoinColumn
    private Users user;
}
