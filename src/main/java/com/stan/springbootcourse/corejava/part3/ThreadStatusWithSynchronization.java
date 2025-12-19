package com.stan.springbootcourse.corejava.part3;

import lombok.Data;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class ThreadStatusWithSynchronization {
    int totalNumber;
    private final Object lockOject = new Object();

    public void incrementNumber() {
        synchronized (lockOject) {
        totalNumber++;
        }
    }
}
