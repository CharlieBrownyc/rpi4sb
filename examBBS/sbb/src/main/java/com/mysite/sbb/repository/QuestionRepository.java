package com.mysite.sbb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysite.sbb.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer>{

    List<Question> findBySubject(String subject);
}
