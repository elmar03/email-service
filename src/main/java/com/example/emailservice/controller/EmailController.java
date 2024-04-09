package com.example.emailservice.controller;

import com.example.emailservice.dto.EmailDto;
import com.example.emailservice.service.EmailService;
import jakarta.mail.MessagingException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/email")
@RequiredArgsConstructor
@RestController
@Data
public class EmailController {

    private final EmailService emailService;


    @PostMapping("/send-Email")
    public String sendMail(@RequestBody EmailDto emailDto){
         emailService.sendMail(emailDto);
         return "Successful";
    }

    @PostMapping("/send-Attachment")
    public String sendAttachment(@RequestBody EmailDto emailDto) throws MessagingException, IOException {
        emailService.sendEmailAttachment(emailDto);
        return "Successful";
    }

    @PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadExcelFile(@RequestParam("partnersExcel") MultipartFile file)
            throws IOException {
        return null;
    }


}
