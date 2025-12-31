package com.stan.springbootcourse.dsa;

public class Arrays {
    public static void main(String[] args) {
        Integer[] arr = new Integer[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;
        System.out.println(java.util.Arrays.toString(arr));

        System.out.println("*********************");
        arr[3] = 6;
        System.out.println(java.util.Arrays.toString(arr));
       // System.out.println(arr);
    }
}
