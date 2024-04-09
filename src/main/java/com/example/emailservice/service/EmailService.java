package com.example.emailservice.service;

import com.example.emailservice.dto.EmailDto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;

    public void sendMail(EmailDto emailDto){
        SimpleMailMessage msg= new SimpleMailMessage();
        msg.setTo(emailDto.getTo());
        msg.setFrom(emailDto.getFrom());
        msg.setSubject(emailDto.getSubject());
        msg.setText(emailDto.getMessage());
        javaMailSender.send(msg);
    }

    public void sendEmailAttachment(EmailDto emailDto) throws MessagingException, IOException{
        MimeMessage message = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        helper.setTo(emailDto.getTo());
        helper.setFrom(emailDto.getFrom());
        helper.setText(emailDto.getMessage());
        helper.setSubject(emailDto.getSubject());
        helper.setText("<h1>Check attachment for image!</h1>", true);
        helper.addAttachment("romanEmpire.jpg",new ClassPathResource("romanEmpire.jpg"));
        javaMailSender.send(message);

    }
}
