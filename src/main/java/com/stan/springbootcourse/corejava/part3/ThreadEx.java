package com.stan.springbootcourse.corejava.part3;

public class ThreadEx {
    public static void main(String[] args) throws InterruptedException {

        System.out.println(Thread.activeCount());
        System.out.println(Runtime.getRuntime().availableProcessors());

        System.out.println(Thread.currentThread().getName());
        Thread myThread = null;
        for (int i = 0; i < 10; i++) {
             myThread = new Thread(new DownloadFile());
            myThread.start();
        }
        myThread.join();

        System.out.println("You can start scanning now");
    }
}
