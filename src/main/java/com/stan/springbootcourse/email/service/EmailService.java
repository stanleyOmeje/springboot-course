package com.stan.springbootcourse.email.service;

import com.stan.springbootcourse.dto.response.DefaultResponse;
import jakarta.mail.MessagingException;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface EmailService {
    DefaultResponse<String> sendMail(@RequestParam(value = "file", required = false) MultipartFile[] file,
                                      String to, String subject, String[] cc,  String body) throws MessagingException;
}
