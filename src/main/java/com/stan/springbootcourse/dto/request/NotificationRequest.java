package com.stan.springbootcourse.dto.request;

import lombok.Data;

@Data
public class NotificationRequest {
    private String to;
    private String subject;
    private String[] cc;
    private String body;
}
