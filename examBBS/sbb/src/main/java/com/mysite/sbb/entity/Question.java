package com.mysite.sbb.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {
    
    @Id // Primary key annotation
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use IDENTITY for auto-incrementing primary key
    private Integer id;

    @Column(length = 200) // Column annotation to specify the length of the subject field
    private String subject; // Subject of the question

    @Column(columnDefinition = "TEXT") // Column annotation to specify that content can be a large text
    private String content; // Content of the question

    @CreatedDate // Automatically set the creation date when the entity is created
    private LocalDateTime createDate;   // Creation date of the question

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE) 
    // One-to-many relationship with Answer entity
    // mappedBy indicates that the Answer entity has a field named 'question' that maps to this entity
    // cascade = CascadeType.REMOVE means that if a Question is deleted, its related Answers will also be deleted
    private List<Answer> answerList;

}
