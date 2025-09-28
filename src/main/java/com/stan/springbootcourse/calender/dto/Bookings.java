package com.stan.springbootcourse.calender.dto;

import lombok.Data;

@Data
public class Bookings {
    private Integer startPoint;
    private Integer endPoint;

    public Bookings(Integer startPoint, Integer endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }
}
