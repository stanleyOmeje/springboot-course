package com.stan.springbootcourse.corejava.part3.functionalinterface.streams;


import java.util.List;
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

        int sun = students
            .stream()
            .filter(s -> s.getAge() > 20)
            .filter(s -> s.getGender().equals("M"))
            .filter(s -> s.getClaz().equals("6"))
            .mapToInt(s -> s.getAge())
            .sum();
        //.reduce(0, sum());
        System.out.println(sun);
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
                    new Student(6, "Chidozie", 30, "M", "6"),
                    new Student(7, "Dele", 40, "M", "4"),
                    new Student(8, "Jide", 50, "M", "5"),
                    new Student(9, "Oscar", 60, "M", "6"),
                    new Student(10, "Shola", 60, "F", "3"),
                    new Student(11, "Segun", 70, "F", "3")
                )
            );

        flatStudent.flatMap(m->m.stream())
            .forEach(System.out::println);

        //flatStudent.forEach(System.out::println);

    }
}
