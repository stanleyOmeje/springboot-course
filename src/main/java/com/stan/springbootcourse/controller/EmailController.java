package com.stan.springbootcourse.controller;

import com.stan.springbootcourse.dto.response.CategoryDto;
import com.stan.springbootcourse.dto.response.DefaultResponse;
import com.stan.springbootcourse.email.service.EmailService;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@RestController
@RequestMapping("api/vi/email")
public class EmailController {
    private EmailService emailService;
    @GetMapping
    public ResponseEntity<DefaultResponse<String>> sendMail(@RequestParam(value = "file", required = false) MultipartFile[]  file,
                                                            String subject, String to,  String[] cc, String body) throws MessagingException {
        DefaultResponse<String> defaultResponse = emailService.sendMail(file, subject, to, cc, body);
        return new ResponseEntity<>(defaultResponse, HttpStatus.OK);
    }
}
