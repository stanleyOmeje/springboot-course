package com.stan.springbootcourse.corejava.part3.comparable;

import lombok.Data;
import lombok.ToString;

//@Data
@ToString
public class  Instructor extends ComparaUser{
    public Instructor(int score) {
        super(score);
    }


}
