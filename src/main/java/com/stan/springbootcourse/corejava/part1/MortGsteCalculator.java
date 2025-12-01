package com.stan.springbootcourse.corejava.part1;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortGsteCalculator {
    public static void main(String[] args) {
        double principal = readVal("Principal: ", 1, 1000000);
        double anualInterest = readVal("anualInterest: ", 1, 10);
        int year = (int) readVal("year: ", 1, 50);
        double m = 0.0;
        m = calculateMortgage(principal, anualInterest, year);
        String mortgage = NumberFormat.getCurrencyInstance().format(m);
        System.out.println();
        System.out.println("############################################ " );
        System.out.println("mortgage = " + mortgage);
        System.out.println("############################################ " );
        System.out.println();
        int numberOfMonths = year * 12;

        printBalance(principal, anualInterest, year, numberOfMonths);
    }

    public static double calculateMortgage(
        double principal,
        double anualInterest,
        int year) {
        final int PERCENTAGE = 100;
        final int MONTHS_IN_YEAR = 12;
        double rate = (anualInterest / MONTHS_IN_YEAR) / PERCENTAGE;
        int period = year * MONTHS_IN_YEAR;
        return principal * (rate * Math.pow((1 + rate), period)) / ((Math.pow((1 + rate), period)) - 1);
    }

    public static double calculateBalance(
        double principal,
        double anualInterest,
        int year,
        int numberOfPayments) {
        final int PERCENTAGE = 100;
        final int MONTHS_IN_YEAR = 12;
        double rate = (anualInterest / MONTHS_IN_YEAR) / PERCENTAGE;
        int period = year * MONTHS_IN_YEAR;
        return principal * ( Math.pow((1 + rate), period) - Math.pow((1 + rate), numberOfPayments)) / ((Math.pow((1 + rate), period)) - 1);
    }

    public static void printBalance(
        double principal,
        double anualInterest,
        int year,
        int numberOfMonths) {
        for(int numberOfPayment = 1; numberOfPayment <= numberOfMonths; numberOfPayment++ ) {
            double balance = calculateBalance(principal, anualInterest, year, numberOfPayment);
            System.out.println("Balance = " + balance);
        }
    }

    public static double readVal(String prompt, double min, double max) {
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

}
