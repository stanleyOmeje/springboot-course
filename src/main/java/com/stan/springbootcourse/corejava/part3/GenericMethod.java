package com.stan.springbootcourse.corejava.part3;

import com.stan.springbootcourse.dto.response.SummaryOutput;

public class GenericMethod {
    public static  <T extends Comparable<T>> T getMax(T t1, T t2) {
        return t1.compareTo(t2)>0  ? t1: t2;
    }

    public static void main(String[] args) {
        User a = new User("stan5","123","stan.com");
        User b = new User("stan1","1234","stan1.com");
       // System.out.println("Max of the two is "+getMax("Z","B"));
        System.out.println("Max of the two is "+getMax(a, b));
    }
}
