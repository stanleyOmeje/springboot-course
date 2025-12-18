package com.stan.springbootcourse.corejava.part3;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx {
    public static void main(String[] args) {
        Stream.of(List.of(1,2,3,4,5),List.of(6,7,8,9,10))
            .flatMap(list->list.stream())
            .forEach(a->{
            System.out.println(a);
        });

        System.out.println("#######################################");

        Stream.of(new User("Chidozie","123","chi@gmail.com",40),
            new User("Sunday","456","sun@gmail.com",35),
            new User("Michael","567","mi@gmail.com",30))
            .sorted(Comparator.comparing(User::getUsername).reversed())
            .forEach(System.out::println);

        System.out.println("***********************************************");

        Integer totalAge =   Stream.of(new User("Chidozie","123","chi@gmail.com",40),
                new User("Sunday","456","sun@gmail.com",35),
                new User("Michael","567","mi@gmail.com",30))
            .map(User::getAge)
            .reduce(0,Integer::sum);

        System.out.println("Total age: "+totalAge);
        System.out.println("***********************************************");

        var obj = Stream.of(new User("Chidozie","123","chi@gmail.com",40),
                new User("Sunday","456","sun@gmail.com",35),
                new User("Michael","567","mi@gmail.com",30))
            .map(User::getUsername)
            .collect(Collectors.joining(","));

        System.out.println("Total age: "+obj);

        System.out.println("***********************************************");
        var obj2 = Stream.of(new User("Chidozie","123","chi@gmail.com",40),
                new User("Sunday","456","sun@gmail.com",35),
                new User("Michael","567","mi@gmail.com",30))
           // .map(User::getUsername)
            .collect(Collectors.groupingBy(User::getEmail,
                Collectors.toMap(User::getUsername,
                    User::getAge,(a,b)->a+b)) );
        System.out.println("obj: "+obj2);

        System.out.println("***********************************************");
        var obj3 = Stream.of(new User("Chidozie","123","chi@gmail.com",40),
                new User("Sunday","456","sun@gmail.com",35),
                new User("Michael","567","mi@gmail.com",30))
            // .map(User::getUsername)
            .collect(Collectors.partitioningBy(user -> user.getAge()>30));
        System.out.println("obj: "+obj3.get(false));
        System.out.println("***********************************************");

       
    }




}
