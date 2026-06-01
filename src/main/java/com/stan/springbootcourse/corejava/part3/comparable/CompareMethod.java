package com.stan.springbootcourse.corejava.part3.comparable;

public class CompareMethod  {

    public static <T extends Comparable> T max(T a, T b) {
      return a.compareTo(b) > 0 ? a : b;
    }

    public static<K, T> void print(K a, T b){
        System.out.println(a+", "+b);
    }

    public static void main(String[] args) {
        print(1,"Dozie");
    }

}
