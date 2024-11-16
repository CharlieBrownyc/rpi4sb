package com.mysite.sbb.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.sbb.entity.Question;

@SpringBootTest
class CRUDTests {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    
    @Autowired
    private QuestionRepository questionRepository;

    @Test
    void testFindBySubject() {
        List<Question> qs = this.questionRepository.findBySubject("sbb란 무엇인가?");

        for (Question q : qs) {
            logger.debug("=================================================================={");
            logger.debug("getId: {}", q.getId());
            // assertEquals("z", q.getSubject());
            logger.debug("==================================================================}");
            assertEquals(1, q.getId());
        }
        
    }

    @Test
    void testFindById() {
        Optional<Question> oq = this.questionRepository.findById(1);
        if(oq.isPresent()) {
            Question q = oq.get();
            logger.debug("=================================================================={");
            logger.debug("First getSubject: {}", q.getSubject());
            // assertEquals("z", q.getSubject());
            logger.debug("==================================================================}");
        }
    }

    @Test
    void testRead(){
        List<Question> questions = this.questionRepository.findAll();
        assertEquals(4, questions.size());
        logger.debug("=================================================================={");
        logger.debug("All questions: {}", questions.get(0).getSubject());

        Question q1 = questions.get(0);
        assertEquals("sbb란 무엇인가?", q1.getSubject());
        // assertEquals("스프링부트보드인가요?", q1.getContent());
        logger.debug("First question: {}", q1.getSubject());
        logger.debug("==================================================================}");
    }

    @Test
    void testJpaRepository() {
        Question q1 = new Question();
        q1.setSubject("sbb란 무엇인가?");
        q1.setContent("스프링부트보드인가요?");
        q1.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q1);

        Question q2 = new Question();
        q2.setSubject("sbb의 주요 기능");
        q2.setContent("1. Spring Boot로 Spring Boot Application을 구��합니다.\n2. JPA(Java Persistence API)를 이용하여 DB를 ORM(Object-Relational Mapping)합니다.\n3. Spring Security를 이용하여 로그인/로그아��/���한 관리합니다.");
        q2.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q2);
    }
}
