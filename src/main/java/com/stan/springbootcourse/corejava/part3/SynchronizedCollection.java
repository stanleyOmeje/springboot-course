package com.stan.springbootcourse.corejava.part3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class SynchronizedCollection {
    public static void main(String[] args) {
        Collection<Integer> collections = Collections.synchronizedCollection(new ArrayList<>());
        Thread thread1 = new Thread(() -> {
            collections.addAll(Arrays.asList(1, 2, 3, 4, 5));
        });
        Thread thread2 = new Thread(() -> {
            collections.addAll(Arrays.asList(6, 7, 8, 9, 10));
        });

        thread1.start();
        thread2.start();

//        thread1.join();
//        thread2.join();

        System.out.println("Collections : " + collections);
    }
}
