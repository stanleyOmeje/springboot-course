package com.stan.springbootcourse.corejava.part3.threads;

import lombok.Data;
import lombok.Synchronized;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class ThreadCount {
    private AtomicInteger count = new AtomicInteger();
   // private Lock lock = new ReentrantLock();
    public void increment() {
        count.incrementAndGet();

//        synchronized (this){
//            count++;
//        }
//        try{
//            lock.lock();
//            count++;
//        }finally {
//           lock.unlock();
//        }
    }

}
