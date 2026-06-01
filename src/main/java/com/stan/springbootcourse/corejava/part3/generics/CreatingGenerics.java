package com.stan.springbootcourse.corejava.part3.generics;

public class CreatingGenerics <T>{

    T[] list = (T[]) new  Object[10];
    int i = 0;

    public void add(T t) {
        list[i++] = t;
    }

    public T get(int i) {
        return list[i];
    }

    public static void main(String[] args) {
        CreatingGenerics<Integer> c = new CreatingGenerics<>();
        c.add(1);
        CreatingGenerics<String> c1 = new CreatingGenerics<>();
        c1.add("Chidozie");
        System.out.println(c1.get(0));
    }
}
