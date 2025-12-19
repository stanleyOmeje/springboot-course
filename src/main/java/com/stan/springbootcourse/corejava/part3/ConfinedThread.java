package com.stan.springbootcourse.corejava.part3;

import java.util.ArrayList;
import java.util.List;

public class ConfinedThread {
    public static void show() throws InterruptedException {
        List<Thread> threads = new ArrayList<Thread>();
        List<DownloadFile> downloadFiles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DownloadFile downloadFile = new DownloadFile();
            downloadFiles.add(downloadFile);
            Thread thread = new Thread(downloadFile);
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join();
        }
        Integer grandTotal = downloadFiles
            .stream()
            .map(file -> file.status.getTotalNumber())
            .reduce(0, Integer::sum);
        System.out.println("grandTotal Download  " + grandTotal);
    }

    public static void main(String[] args) throws InterruptedException {
        show();
    }
}
