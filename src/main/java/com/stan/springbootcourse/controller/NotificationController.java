package com.stan.springbootcourse.controller;

import com.stan.springbootcourse.dto.request.NotificationRequest;
import com.stan.springbootcourse.dto.response.DefaultResponse;
import com.stan.springbootcourse.event.publisher.service.NotificationEventPublisher;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/notify")
public class NotificationController {
    private final NotificationEventPublisher notificationEventPublisher;
    @PostMapping
    public ResponseEntity<DefaultResponse<String>> pushNotification(@RequestParam(value = "to", required = false) String to,
                                                                     @RequestParam(value = "subject", required = false) String subject,
                                                                     @RequestParam(value = "cc", required = false) String[] cc,
                                                                     @RequestParam(value = "body", required = false) String body
    ) {
        DefaultResponse<String> response = new DefaultResponse<String>();
        NotificationRequest message = new NotificationRequest();
        message.setTo(to);
        message.setSubject(subject);
        message.setCc(cc);
        message.setBody(body);

        notificationEventPublisher.publishEvent(message);

        response.setStatus("00");
        response.setMessage("Notification successful");

        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
