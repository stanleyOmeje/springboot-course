package com.stan.springbootcourse.corejava.part3.threads;

import java.util.ArrayList;
import java.util.List;

public class MainThread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Thread Name: "+Thread.currentThread().getName());
        System.out.println("Thread count: "+Thread.activeCount());
        System.out.println("Thread availableProcessors: "+Runtime.getRuntime().availableProcessors());

        ThreadFactories factories = new ThreadFactories();
        factories.createThreads();
        System.out.println("I am the main thread "+Thread.currentThread().getName());
    }
}
