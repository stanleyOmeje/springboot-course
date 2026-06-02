package com.stan.springbootcourse.corejava.part3.comparable;

import com.stan.springbootcourse.corejava.part3.generics.CreatingGenerics;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompareMethod  {

    public static <T extends Comparable> T max(T a, T b) {
      return a.compareTo(b) > 0 ? a : b;
    }

    public static<K, T> void print(K a, T b){
        System.out.println(a+", "+b);
    }

    public static void printCompareUser(ComparaUser a){
        System.out.println(a);
    }

    public static void printListCompareUser(CreatingGenerics<? extends ComparaUser>  b){
        System.out.println(b.get(0));
    }

    public static void main(String[] args) {
       // print(1,"Dozie");

        ComparaUser c1 = new ComparaUser(1);
        ComparaUser c2 = new Instructor(2);
       // print(c1, c2);

        CreatingGenerics<ComparaUser> c3 = new CreatingGenerics<>();
        CreatingGenerics<Instructor> c4 = new CreatingGenerics<>();
        Instructor i1 = new Instructor(1);
        Instructor i2 = new Instructor(2);
        Instructor i3 = new Instructor(3);
        c4.add(i1);
        c4.add(i2);
        c4.add(i3);

        printCompareUser(c1);
        printCompareUser(c2);

        printListCompareUser(c4);
//        printListCompareUser(Stream.of(c4).map(c->{
//            CreatingGenerics<ComparaUser> c5 = new CreatingGenerics<>();
//            ComparaUser c6 = new Instructor(c.get(0).getScore());
//            c5.add(c6);
//            return c5;
//        }).collect(Collectors.));
    }

//    public CreatingGenerics<ComparaUser> mapToCreatingGenerics(CreatingGenerics<Instructor>  s){
//
//        CreatingGenerics<ComparaUser> a = new CreatingGenerics<>();
//        for (Instructor is : s){
//
//        }
//    }

}
