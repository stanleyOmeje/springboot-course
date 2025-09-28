package com.stan.springbootcourse.dependencyInjections;


import com.stan.springbootcourse.config.NotificationConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NotificationMain {
    @Value("${notification.type:}")
    private String notificationType;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(NotificationConfig.class);
        NotificationManager notificationManager = context.getBean(NotificationManager.class);
        notificationManager.processNotification("Hello World");

        System.out.println("Notification type is "+new NotificationMain().notificationType);


    }
}
