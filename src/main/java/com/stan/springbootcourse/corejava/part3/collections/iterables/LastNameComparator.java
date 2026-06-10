package com.stan.springbootcourse.corejava.part3.collections.iterables;

import java.util.Comparator;

public class LastNameComparator implements Comparator<Users> {
    @Override
    public int compare(Users o1, Users o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
