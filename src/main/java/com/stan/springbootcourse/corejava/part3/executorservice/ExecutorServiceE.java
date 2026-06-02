package com.stan.springbootcourse.corejava.part3.executorservice;

import com.stan.springbootcourse.corejava.part3.comparable.Instructor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceE {

    public void creatingThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try {
            for (int i = 0; i < 5; i++) {
                executorService.submit(this::multiplicationTable);
            }
        }finally {
            executorService.shutdown();
        }
    }

    public void multiplicationTable()
    {
        System.out.println("Multiplication Table");
        for (int i = 1; i <= 12; i++) {
           System.out.println("2 * "+i+" = "+(i*2));
        }
    }
    public static void main(String[] args) {
        ExecutorServiceE executor = new ExecutorServiceE();
        executor.creatingThreadPool();
    }
}
