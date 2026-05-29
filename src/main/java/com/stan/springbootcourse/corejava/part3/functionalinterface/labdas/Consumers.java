package com.stan.springbootcourse.corejava.part3.functionalinterface.labdas;

import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Consumers {
    static String c = "Greeting to you: ";

    public static void main(String[] args) {
        List<String> list = List.of("Hello", "World");
        //Consumer<String> l = list.forEach(item->System.out.println(item));
        Consumer<String> consumers = me -> System.out.println(c + me);
        Consumer<String> consumer2 = me -> System.out.println(c + me.toUpperCase());

        list.forEach(consumers.andThen(consumer2));
        System.out.println();

        System.out.println("|||||||||||||||||| SUPLIER ||||||||||||||||||||||");

        Supplier<String> p = () -> {
            double d = Math.random();
            String ref = "Chi" + new Date().getTime() + "-" + d;
            return ref;
        };
        String clintRef = p.get();
        System.out.println("Your reference is " + p.get());
        System.out.println("Your Client Ref is " + clintRef);
        System.out.println();

        System.out.println("|||||||||||||||||| FUNCTION ||||||||||||||||||||||");

        Function<String, String> name = (nam) -> {
            return "Your name is" + nam;
        };

        String yName = name.apply("Chidozie");

        System.out.println("Your name is " + yName);

    }
}
