package com.example.threadex.email.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailDto {
    private String recipient;
    private String subject;
    private String content;
}
