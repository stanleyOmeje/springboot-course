package com.stan.springbootcourse.email.service.impl;

import com.stan.springbootcourse.dto.response.DefaultResponse;
import com.stan.springbootcourse.email.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmailServiceImpl implements EmailService {

    @Value("${spring.mail.password: }")
    private String fromMail;
    private final JavaMailSender javaMailSender;

    @Override
    public DefaultResponse<String> sendMail(MultipartFile[] file, String to, String subject, String[] cc, String body)
        throws MessagingException {
        log.debug("Inside sendMail method of EmailService");
        DefaultResponse<String> defaultResponse = new DefaultResponse<>();
       try{
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setCc(cc);
        mimeMessageHelper.setFrom(fromMail);
        if (file != null && file.length > 0) {
            for (int i = 0; i < file.length; i++) {
                mimeMessageHelper.addAttachment(Objects.requireNonNull(file[i].getOriginalFilename()), new ByteArrayResource(file[i].getBytes()));
            }
        }
       javaMailSender.send(mimeMessage);
        defaultResponse.setStatus("00");
        defaultResponse.setMessage("Success");
        defaultResponse.setData("Email sent successfully");

        log.debug("Email sent successfully");
        return defaultResponse;
    }catch (IOException e) {
           throw new RuntimeException(e);
       }
    catch (MessagingException e){
       e.printStackTrace();
       }
        return defaultResponse;
    }
}
