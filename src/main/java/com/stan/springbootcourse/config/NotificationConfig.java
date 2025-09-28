package com.stan.springbootcourse.config;


import com.stan.springbootcourse.dependencyInjections.EmailNotificationService;
import com.stan.springbootcourse.dependencyInjections.NotificationManager;
import com.stan.springbootcourse.dependencyInjections.NotificationService;
import com.stan.springbootcourse.dependencyInjections.SMSNotificationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"com.stan.springbootcourse.dependencyInjections"})
@Configuration()
public class NotificationConfig {
    @Value("${notification:}")
    private String notificationType;

    @Bean
    public NotificationService sms(){
        return new SMSNotificationService();
    }

    @Bean
    public NotificationService email(){
        return new EmailNotificationService();
    }

    @Bean
    public NotificationManager manager() {
        if (notificationType.equalsIgnoreCase("SMS")) {
            return new NotificationManager(sms());
        }
            return new NotificationManager(email());
    }
}
