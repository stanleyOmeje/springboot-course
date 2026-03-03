package com.stan.springbootcourse.corejava.part3.executorframework;

public class AsyncClass {
    public static void main(String[] args) throws InterruptedException {
        EmailClass.sendMailAsync();
        System.out.println("Do more job");
        Thread.sleep(3000);
    }

}
