package com.stan.springbootcourse.dependencyInjections;

//@Service("sms")
public class SMSNotificationService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("SMS message "+  message);
    }
}
