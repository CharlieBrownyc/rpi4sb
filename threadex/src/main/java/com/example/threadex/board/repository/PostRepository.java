package com.example.threadex.board.repository;

import com.example.threadex.board.entity.Post;

import java.util.List;
import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByTitle(String title);
    List<Post> findByTitleContaining(String title);
    Page<Post> findByTitleContaining(String title, Pageable pageable);

    // Custom query method to find posts by author
    List<Post> findByAuthor(String author);
    List<Post> findByAuthorContaining(String author);

    List<Post> findByCreatedAtBetween(LocalDateTime startTime, LocalDateTime endTime);
    List<Post> findByTitleOrderByCreatedAtDesc(String title);

    // Custom query method to find posts by content
    List<Post> findByContentContaining(String content);
    List<Post> findByTitleAndContent(String title, String content);
    List<Post> findByTitleLike(String title);
    List<Post> findByContentLike(String content);
    Page<Post> findAll(Pageable pageable);
    
} 