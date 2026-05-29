package com.stan.springbootcourse.corejava.part3.functionalinterface.streams;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String claz;

    public Student(int id, String name, int age, String gender, String claz) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.claz = claz;
    }
}
