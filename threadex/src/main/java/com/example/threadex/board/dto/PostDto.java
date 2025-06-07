package com.example.threadex.board.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {
    private Long id; // Unique identifier for the post
    private String title; // Title of the post
    private String content; // Content of the post
    private String author; // Author of the post   
    
}
