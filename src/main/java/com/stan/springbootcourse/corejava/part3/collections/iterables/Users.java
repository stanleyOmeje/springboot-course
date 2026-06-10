package com.stan.springbootcourse.corejava.part3.collections.iterables;

import lombok.Data;

@Data
public class Users implements Comparable<Users> {
    private String firtName;
    private String lastName;
    private int age;

    public Users(String firtName, String lastName, int age) {
        this.firtName = firtName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public int compareTo(Users o) {
        return firtName.compareTo(o.firtName);
    }
}
