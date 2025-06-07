package com.example.threadex.email.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Email {
    
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100) // Column annotation to specify the length of the recipient field
    private String recipient;

    @Column(length = 200) // Column annotation to specify the length of the subject field
    private String subject;

    @Column(columnDefinition = "TEXT") // Column annotation to specify that content can be a large text
    private String content;

    @Enumerated(EnumType.STRING)
    private EmailStatus status;

    @Column(length = 50) // Column annotation to specify the length of the error message field
    private int retryCount;

    @CreatedDate
    private LocalDateTime sentAt;

    
    
}
