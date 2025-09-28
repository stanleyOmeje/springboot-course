package com.stan.springbootcourse.event.publisher.service;

import com.stan.springbootcourse.dto.request.NotificationRequest;
import com.stan.springbootcourse.event.EventTopic;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;

import java.util.Objects;

@Slf4j
@AllArgsConstructor
@Service
public class NotificationEventPublisher {

    private final KafkaTemplate<String, String> kafkaTemplate;
    Gson gson = new Gson();

    public void publishEvent(NotificationRequest message) {
        log.info("Publishing notification event: {}", message);
        try {
            if (Objects.isNull(message)) {
                throw new IllegalArgumentException("message is null");
            }
            kafkaTemplate.send(EventTopic.NOTIFICATION_TOPIC, gson.toJson(message));
            log.info("Notification event published");
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }

}
