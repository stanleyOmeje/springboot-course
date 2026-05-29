package com.stan.springbootcourse.corejava.part3.functionalinterface.streams;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainStream {

    public static void main(String[] args) {
        List<Student> students = List.of(
            new Student(1, "Chidozie", 30, "M", "6"),
            new Student(2, "Dele", 40, "M", "4"),
            new Student(3, "Jide", 50, "M", "5"),
            new Student(4, "Oscar", 60, "M", "6"),
            new Student(5, "Shola", 60, "F", "3")
        );

        var ms = students.stream()
                .collect(Collectors.groupingBy(Student::getClaz, Collectors.toList()));
        System.out.println(ms);


        System.out.println("=======================================================");

        int sun = students
            .stream()
            .filter(s -> s.getAge() > 20)
            .filter(s -> s.getGender().equals("M"))
            .filter(s -> s.getClaz().equals("6"))
           .mapToInt(s -> s.getAge())
            .reduce(0, Integer::sum);
//            .sum();
        //.reduce(0, sum());
        System.out.println("The sum of the ages is "+sun);
        System.out.println("=======================================================");

        var flatStudent = Stream.of(
                List.of(
                    new Student(1, "Chidozie", 30, "M", "6"),
                    new Student(2, "Dele", 40, "M", "4"),
                    new Student(3, "Jide", 50, "M", "5"),
                    new Student(4, "Oscar", 60, "M", "6"),
                    new Student(5, "Shola", 60, "F", "3")
                ),
                List.of(
                    new Student(6, "Ade", 30, "M", "6"),
                    new Student(7, "Obi", 40, "M", "4"),
                    new Student(8, "Kaima", 50, "M", "5"),
                    new Student(9, "Favour", 60, "M", "6"),
                    new Student(10, "Shola", 60, "F", "3"),
                    new Student(11, "Segun", 70, "F", "3")
                )
            );

//        flatStudent.flatMap(m->m.stream())
//            .sorted((a,b)->a.getName().compareTo(b.getName()))
//            .forEach(System.out::println);

//        flatStudent.flatMap(m->m.stream())
//            .sorted((a,b)->Integer.compare(a.getAge(),b.getAge()))
//            .forEach(System.out::println);

        flatStudent.flatMap(m->m.stream())
            .sorted(Comparator.comparing(Student::getAge))
            .forEach(System.out::println);

        //flatStudent.forEach(System.out::println);

    }
}
