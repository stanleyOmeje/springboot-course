package com.stan.springbootcourse.corejava.part3;

public class DownloadFile implements Runnable {
    ThreadStatus status;

    public DownloadFile() {
        this.status = new ThreadStatus();
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Downloading file with " + Thread.currentThread().getName());
            status.incrementNumber();
        }
        System.out.println("Download Completes " + Thread.currentThread().getName());
    }
}
