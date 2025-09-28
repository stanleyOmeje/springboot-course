package com.stan.springbootcourse.event.listener.service;

import com.stan.springbootcourse.dto.request.NotificationRequest;
import com.stan.springbootcourse.dto.response.DefaultResponse;
import com.stan.springbootcourse.email.service.EmailService;
import com.stan.springbootcourse.event.EventGroup;
import com.stan.springbootcourse.event.EventTopic;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Slf4j
@Service
public class NotificationEventListener {

    private final EmailService emailService;

    @KafkaListener(topics = EventTopic.NOTIFICATION_TOPIC, groupId = EventGroup.NOTIFICATION_GROUP)
    public void listenToPublishedEvent(NotificationRequest message) {
        DefaultResponse<String> defaultResponse = new DefaultResponse();
        log.info("Inside listenToPublishedEvent with received message: {}", message);
        try {
            defaultResponse = emailService.sendMail(null, message.getSubject(), message.getBody(), message.getCc(), message.getTo());
            log.info("Response from listenToPublishedEvent ::: {}", defaultResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
