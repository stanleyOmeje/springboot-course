package com.stan.springbootcourse.corejava.part3.threads.threadconcurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class SynchronizedCollection {

    public  void mergeCollection() throws InterruptedException {
        Collection<Integer> collection =
            Collections.synchronizedCollection(new ArrayList<Integer>());
            //new ArrayList<>();
        Thread thread1 = new Thread(
            ()-> collection.addAll(Arrays.asList(5,6,7,8))
        );
        Thread thread2 = new Thread(
            ()-> collection.addAll(Arrays.asList(1, 2, 3, 4))
        );
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(collection);
       ;
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedCollection sc = new SynchronizedCollection();
        sc.mergeCollection();
    }
}
