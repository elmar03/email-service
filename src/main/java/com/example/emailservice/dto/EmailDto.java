package com.example.emailservice.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EmailDto {
    private String from;
    private String to;
    private String subject;
    private String message;
}
