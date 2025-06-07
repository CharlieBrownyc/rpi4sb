package com.example.threadex.board.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

@Getter
@Setter
@Entity
public class Post {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use IDENTITY for auto-incrementing primary key
    private Long id;

    @Column(length = 200) // Column annotation to specify the length of the title field
    private String title;

    @Column(columnDefinition = "TEXT") // Column annotation to specify that content can be a large text
    private String content;

    @Column(length = 100) // Column annotation to specify the length of the author field
    private String author;

    @CreatedDate
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}