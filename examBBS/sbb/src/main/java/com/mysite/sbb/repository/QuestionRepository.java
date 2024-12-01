package com.mysite.sbb.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mysite.sbb.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer>{

    List<Question> findBySubject(String subject);    
    List<Question> findBySubjectContaining(String subject);
    List<Question> findByCreateDateBetween(LocalDateTime starTime, LocalDateTime endTime);
    List<Question> findBySubjectOrderByCreateDateDesc(String subject);
    Page<Question> findByContentContaining(String content, Pageable pageable);
    Page<Question> findBySubjectAndContent(String subject, String content, Pageable pageable);    
    List<Question> findBySubjectLike(String subject);
    Page<Question> findAll(Pageable pageable);
}
