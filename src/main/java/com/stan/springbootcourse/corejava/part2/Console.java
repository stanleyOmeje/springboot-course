package com.stan.springbootcourse.corejava.part2;

import lombok.Data;

import java.util.Scanner;

@Data
public class Console {
    public double readVal(String prompt, double min, double max) {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        double value = sc.nextDouble();
        while (value < min || value > max) {
            System.out.println("Enter an amount between 1 and 10: ");
            value = sc.nextDouble();
        }
        System.out.println(prompt + " " + value);
        return value;
    }

    public void display(){
        MortgageCalculator mortgageCalculator = new MortgageCalculator();
        mortgageCalculator.printMortgage();
        mortgageCalculator.printBalance();
    }
}
