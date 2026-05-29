package com.stan.springbootcourse.corejava.part3.functionalinterface.labdas;

import com.stan.springbootcourse.util.utilities.StringUtil;

import java.util.function.Predicate;

public class Predicates {

    public static boolean checkLenghGthan5(String name){
        if (!StringUtil.isNotBlank(name)){
            return false;
        }
        Predicate<String> ck = str-> str.length()>5;
        return ck.test(name);
    }

    public static void main(String[] args) {
        System.out.println("Chidozie is longer than 5: "+checkLenghGthan5("Chi"));
    }
}
