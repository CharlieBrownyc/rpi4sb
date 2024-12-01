package com.mysite.sbb.repository;

import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.mysite.sbb.entity.Question;
import com.mysite.sbb.service.AnswerService;
import com.mysite.sbb.service.QuestionService;

@SpringBootTest
class CRUDTests {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    @Test
    void testDelete(){
        logger.info("==================================================================testDelete1(){");
        logger.info("Question count: {}", this.questionRepository.count());

        Optional<Question> oq = this.questionRepository.findById(2);
        logger.info("Optional Question is present: {}", oq.isPresent());
        Question q1 = oq.get();
        this.questionRepository.delete(q1);
        logger.info("Question count: {}", this.questionRepository.count());
        
        List<Question> questions = this.questionRepository.findAll();
        logger.info("==================================================================testDelete2{");
        questions.forEach(
            q -> {
                logger.info("id: {} | subject: {} | content: {}", q.getId(), q.getSubject(), q.getContent());
            }
        );
        logger.info("==================================================================}");

    }

    @Test
    void testUpdate(){
        Optional<Question> questionOptional = this.questionRepository.findById(1);
        logger.info("==================================================================testUpdate(){");
        if(questionOptional.isPresent()){
            Question question = questionOptional.get();
            question.setSubject("바꾼다. 제목을 (updated)");
            this.questionRepository.save(question);
        }
        logger.info("==================================================================}");
    }
    
    @Test
    void testfindBySubjectLike(){
        List<Question> qs = this.questionRepository.findBySubjectLike("%sbb%");
        for (Question q : qs) {
            logger.info("==================================================================testfindBySubjectLike(){");
            logger.info("id: {} | createDate: {}", q.getId(), q.getCreateDate());
            logger.info("==================================================================}");
        }        
    }

    @Test
    void testFindBySubjectAndContent(){
        Pageable pageable = PageRequest.of(0, 10);
        Page<Question> qs = this.questionRepository.findBySubjectAndContent("sbb란 무엇인가?", "스프링부트보드인가요?", pageable);
        for (Question q : qs) {
            logger.info("==================================================================testFindBySubjectAndContent(){");
            logger.info("id: {} | createDate: {}", q.getId(), q.getCreateDate());
            logger.info("==================================================================}");
        }
    }

    @Test
    void testfindByContentContaining(){

        Pageable pageable = PageRequest.of(0, 10);
        Page<Question> qs = this.questionRepository.findByContentContaining("JPA", pageable);
        for (Question q : qs) {
            logger.info("==================================================================testFindByCreateDateBetween(){");
            logger.info("id: {} | createDate: {}", q.getId(), q.getCreateDate());
            logger.info("==================================================================}");
        }
    }
    @Test
    void testfindBySubjectOrderByCreateDateDesc(){

        List<Question> qs = 
            this.questionRepository.findBySubjectOrderByCreateDateDesc("sbb란 무엇인가?");
        for (Question q : qs) {
            logger.info("==================================================================testFindByCreateDateBetween(){");
            logger.info("id: {} | createDate: {}", q.getId(), q.getCreateDate());
            // assertEquals("z", q.getSubject());
            logger.info("==================================================================}");
            // assertEquals(1, q.getId());
        }
    }

    @Test
    void testfindByCreateDateBetween(){

        List<Question> qs = 
            this.questionRepository.findByCreateDateBetween(
                LocalDateTime.of(2024, 11, 11, 04, 0), 
                LocalDateTime.of(2024, 11, 30, 23, 59)
            );
        for (Question q : qs) {
            logger.info("==================================================================testFindByCreateDateBetween(){");
            logger.info("id: {} | createDate: {}", q.getId(), q.getCreateDate());
            // assertEquals("z", q.getSubject());
            logger.info("==================================================================}");
            // assertEquals(1, q.getId());
        }
    }
    
    @Test
    void testFindBySubjectContaining() {
        List<Question> qs = this.questionRepository.findBySubjectContaining("sbb");
        for (Question q : qs) {
            logger.info("==================================================================testFindBySubjectContaining(){");
            logger.info("id: {} | subject: {}", q.getId(), q.getSubject());
            // assertEquals("z", q.getSubject());
            logger.info("==================================================================}");
            // assertEquals(1, q.getId());
        }
        
    }

    @Test
    void testFindBySubject() {
        List<Question> qs = this.questionRepository.findBySubject("sbb란 무엇인가?");

        for (Question q : qs) {
            logger.info("==================================================================testFindBySubject(){");
            logger.info("getId: {}", q.getId());
            // assertEquals("z", q.getSubject());
            logger.info("==================================================================}");
            // assertEquals(1, q.getId());
        }
        
    }

    @Test
    void testFindById() {
        Optional<Question> oq = this.questionRepository.findById(1);
        if(oq.isPresent()) {
            Question q = oq.get();
            logger.info("=================================================================={");
            logger.info("First getSubject: {}", q.getSubject());
            // assertEquals("z", q.getSubject());
            logger.info("==================================================================}");
        }
    }

    @Test
    void testRead(){
        List<Question> questions = this.questionRepository.findAll();
        // assertEquals(4, questions.size());
        logger.info("=================================================================={");
        questions.forEach(
            q -> {
                logger.info("id: {} | subject: {} | content: {}", q.getId(), q.getSubject(), q.getContent());
                // assertEquals("z", q.getSubject());
            }
        );
        logger.info("==================================================================}");
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
    
    @Test
    void testSaveDatas(){        
        for (int i = 1; i <= 300; i++) {            
            String subject = String.format("테스트 데이터:[%03d]", i);
            String content = "내용무";
            this.questionService.create(subject, content);
        }
    }

    @Test
    void testSaveAnswers(){
        for (int i = 431; i<= 632; i++){
            for (int j = 0; j< 3; j++){
                String content = String.format("테스트 답변:[%03d]", i);
                Question question = this.questionService.getQuestion(i);
                this.answerService.create(question, content);
            }            
        }
    }

    @Test
    void testSave() {
        Question q1 = new Question();
        q1.setSubject(generateRandomString());
        q1.setContent(generateRandomString());
        q1.setCreateDate(LocalDateTime.now());
        Question savedQuestion = this.questionRepository.save(q1);
    
        logger.info("==================================================================testSave(){");
        logger.info("Saved question: id={}, subject={}, content={}, createDate={}",
            savedQuestion.getId(), savedQuestion.getSubject(), savedQuestion.getContent(), savedQuestion.getCreateDate());
    
        // Assert that the question was saved successfully
        // assertNotNull(savedQuestion.getId());
        assertEquals(q1.getSubject(), savedQuestion.getSubject());
        assertEquals(q1.getContent(), savedQuestion.getContent());
        logger.info("==================================================================}");
    }
    
    private String generateRandomString() {
        return UUID.randomUUID().toString().substring(0, 10);
    }

    private String generateRandomKoreanString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char koreanChar = (char) (0xAC00 + Math.random() * 11172);
            sb.append(koreanChar);
        }
        return sb.toString();
    }
}
