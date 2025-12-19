package com.stan.springbootcourse.corejava.part3;

import lombok.Data;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class ThreadStatusWithLock {
    int totalNumber;
    private Lock lock = new ReentrantLock();

    public void incrementNumber() {
        try{
        lock.lock();
        totalNumber++;
        }finally {
            lock.unlock();
        }
    }
}
