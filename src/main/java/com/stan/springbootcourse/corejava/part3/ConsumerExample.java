package com.stan.springbootcourse.corejava.part3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ConsumerExample {
    public static void main(String[] args) {
        List<String> list = List.of("Hello", "World");
        Consumer<String> print = item-> System.out.println(item);
        Consumer<String> printToUpper = item-> System.out.println(item.toUpperCase());

        list.forEach(print.andThen(printToUpper));
        System.out.println(";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;");

        Supplier<String> name = ()-> "Stan".toUpperCase();
        System.out.println(name.get());

        System.out.println("#########################");

        Function<String, String> toUpperCase = item-> item.toUpperCase();
        System.out.println(toUpperCase.apply("Hello"));

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        Function<Integer, Map<String, Integer>> multiply = item-> {
            Map<String, Integer> map = new HashMap<>();
            for(int i = 0; i < item; i++){
               map.put("2 * " + i  , i*2);
            }
            return map;
        };
     System.out.println(multiply.apply(12));

        System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");

        Predicate<String> longerthan5 = item-> item.length() > 5;
        System.out.println(longerthan5.test("Hello"));
    }
}
