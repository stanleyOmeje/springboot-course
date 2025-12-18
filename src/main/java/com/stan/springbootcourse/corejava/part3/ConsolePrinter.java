package com.stan.springbootcourse.corejava.part3;

public class ConsolePrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println("YOUR Console message is::: "+message);
    }
}
