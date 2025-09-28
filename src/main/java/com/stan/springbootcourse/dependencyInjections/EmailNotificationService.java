package com.stan.springbootcourse.dependencyInjections;

//@Service("email")
//@Primary
public class EmailNotificationService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Email message "+message);
    }
}
