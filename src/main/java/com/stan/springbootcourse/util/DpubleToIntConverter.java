package com.stan.springbootcourse.util;

public class DpubleToIntConverter {
    private static int extractCode(Double r) {
        if (r == null) return 0;
       // final double rc = r.getResponseCode();
        return (int) Math.round(r);
    }
    public static void main(String[] args) {
        System.out.println("The integer equivalent of the double is "+DpubleToIntConverter.extractCode((double)1.5));
    }
}
