package com.stan.springbootcourse.dependencyInjections;

//@Service
public class NotificationManager {

    private final NotificationService notificationService;

    public NotificationManager( NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void processNotification(String message) {
        notificationService.send(message);
    }

}
