package com.stan.springbootcourse.corejava.part3.threads.threadconcurrency;

import lombok.Data;

@Data
public class ThreadCount {
    private int count = 0;

    public void increment() {
        count++;
    }

}
