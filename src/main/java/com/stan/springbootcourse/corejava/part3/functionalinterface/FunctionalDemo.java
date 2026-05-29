package com.stan.springbootcourse.corejava.part3.functionalinterface;

public class FunctionalDemo {

    public void show() {
        greet(new Printer() {
            @Override
            public void print(String message) {
                System.out.println(message);
            }
        });
    }

    public void show2() {
        String content = "Stan!";
        greet(message -> System.out.println(content + message));
    }

    public void show3() {
        greet(System.out::println);
    }


    public static void greet(Printer printer){
        printer.print("Hello World 3");
    }

    public static void main(String[] args) {
        FunctionalDemo demo = new FunctionalDemo();
        demo.show2();
    }
}
