package com.stan.springbootcourse.config;

import com.stan.springbootcourse.dto.request.NotificationRequest;
import com.stan.springbootcourse.event.EventGroup;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class KafkaConsumerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${properties.max-poll-records}")
    private int maxPollRecords;

    @Value("${properties.off-set-config}")
    private String offSetConfig;

    @Value("${properties.poll-interval}")
    private int maxPollInterval;

    @Value("${properties.concurrency}")
    private int concurrency;


    private Map<String, Object> commonConfigProps() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configProps.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false); // Disable auto-commit
        configProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, offSetConfig); // Start from the earliest message
        configProps.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxPollRecords); // Process one record at a time
        configProps.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, maxPollInterval); // 5 minutes interval
        configProps.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 15000); // Consumer session timeout
        return configProps;
    }

    @Bean
    public ConsumerFactory<String, NotificationRequest> consumerFactory() {
        Map<String, Object> configProps = commonConfigProps();
        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, EventGroup.NOTIFICATION_GROUP);
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class.getName());
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class.getName());
        configProps.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, JsonDeserializer.class.getName());
        configProps.put(JsonDeserializer.TRUSTED_PACKAGES, "*");

        return new DefaultKafkaConsumerFactory<>(
            configProps,
            new ErrorHandlingDeserializer<>(new StringDeserializer()),
            new ErrorHandlingDeserializer<>(new JsonDeserializer<>(NotificationRequest.class))
        );
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, NotificationRequest> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, NotificationRequest> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE); // Manual commit mode
        factory.setConcurrency(concurrency); // Single-threaded consumption to ensure order
        return factory;
    }
}
