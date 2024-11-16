package com.mysite.sbb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysite.sbb.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Integer>  {
    
}
