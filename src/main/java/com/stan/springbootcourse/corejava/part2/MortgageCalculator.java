package com.stan.springbootcourse.corejava.part2;

import lombok.Data;

import java.text.NumberFormat;

@Data
public class MortgageCalculator {
    final int PERCENTAGE = 100;
    final int MONTHS_IN_YEAR = 12;

    private double principal;
    private double anualInterest;
    private int year;

    public MortgageCalculator() {
        getValuees();
    }

    public double calculateMortgage() {
        double rate = getRate();
        int period = getPeriod();
        return principal * (rate * Math.pow((1 + rate), period)) / ((Math.pow((1 + rate), period)) - 1);
    }

    private int getPeriod() {
        return year * MONTHS_IN_YEAR;
    }

    public double calculateBalance(int numberOfPayments) {
        double rate = getRate();
        int period = getPeriod();
        return principal * (Math.pow((1 + rate), period) - Math.pow((1 + rate), numberOfPayments)) / ((Math.pow((1 + rate), period)) - 1);
    }

    private double getRate() {
        return (anualInterest / MONTHS_IN_YEAR) / PERCENTAGE;
    }

    public void printMortgage() {
        double m = calculateMortgage();
        String mortgage = NumberFormat.getCurrencyInstance().format(m);
        System.out.println();
        System.out.println("############################################ " );
        System.out.println("mortgage = " + mortgage);
        System.out.println("############################################ " );
    }
    public void printBalance() {
        int numberOfMonths = getPeriod();
        for (int numberOfPayment = 1; numberOfPayment <= numberOfMonths; numberOfPayment++) {
            double balance = calculateBalance(numberOfPayment);
            System.out.println("Balance = " + balance);
        }
    }
    public void getValuees(){
        Console console = new Console();
        principal = console.readVal("Principal: ", 1, 1000000);
        anualInterest = console.readVal("anualInterest: ", 1, 10);
        year = (int) console.readVal("year: ", 1, 50);
    }


    public static void main(String[] args) {
        Console console = new Console();
        console.display();
    }
}
