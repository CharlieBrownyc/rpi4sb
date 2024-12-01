package com.mysite.sbb.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.mysite.sbb.entity.Answer;
import com.mysite.sbb.entity.Question;

import java.util.UUID;

@SpringBootTest
class AnswerRepositoryTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Transactional
    @Test
    void testGetAnswerListByQuestionId() {
        Optional<Question> oq = this.questionRepository.findById(5);
        assertTrue(oq.isPresent());
        Question q = oq.get();
        List<Answer> answers = q.getAnswerList();

        logger.info("==================================================================testGetAnswerListByQuestionId(){");
        // org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: com.mysite.sbb.entity.Question.answers: could not initialize proxy - no Session
        // -> @Transactional (org.springframework.transaction.annotation.Transactional)
        for (Answer answer : answers) {
            logger.info("answer id: {}, question subject: {}, content: {}", answer.getId(), answer.getQuestion().getSubject(), answer.getContent());
        }
        logger.info("==================================================================}");
        assertEquals(3, answers.size());
        assertEquals("답변댓글답변답변댓글답변답변댓글답변", answers.get(0).getContent());
    }

    @Test
    void testReadAnswerAll(){
        Iterable<Answer> answers = this.answerRepository.findAll();
        int count = 0;
        logger.info("==================================================================testReadAnswerAll(){"); 
        for (Answer a : answers) {
            logger.info("id: {}, question subject: {}, content: {}", a.getId(), a.getQuestion().getSubject(), a.getContent());
            count++;
        }
        assertEquals(3, count); // Assuming there are three answers in the database
        logger.info("==================================================================}");
    }

    @Test
    void testReadAnswer() {
        Optional<Answer> oa = this.answerRepository.findById(1);
        assertTrue(oa.isPresent());
        Answer a = oa.get();
        // assertEquals(2, a.getQuestion().getId());
        logger.info("==================================================================testReadAnswer(){");
        logger.info("id: {}, question subject: {}, content: {}", a.getId(), a.getQuestion().getSubject(), a.getContent());
        logger.info("==================================================================}");
    }

    @Test
    void testCreateQuestionAnswers(){

        // Create a Question with random subject and content
        Question q = new Question();
        q.setSubject(generateRandomString());
        q.setContent(generateRandomString());
        q.setCreateDate(LocalDateTime.now());
        Question savedQuestion = this.questionRepository.save(q);
        
        // Create multiple Answers for the Question
        for (int i = 0; i < 10; i++) {
            Answer a = new Answer();
            a.setContent(generateRandomString());
            a.setQuestion(savedQuestion);
            a.setCreateDate(LocalDateTime.now());
            Answer savedAnswer = this.answerRepository.save(a);

            logger.info("Saved Answer: id={}, content={}, questionId={}", 
                    savedAnswer.getId(), savedAnswer.getContent(), savedAnswer.getQuestion().getId());
        }

        // Retrieve the Question with its Answers
        Optional<Question> retrievedQuestionOpt = this.questionRepository.findById(savedQuestion.getId());
        assertTrue(retrievedQuestionOpt.isPresent());
        // Question retrievedQuestion = retrievedQuestionOpt.get();

        // Assert that the Question has 3 Answers
        // assertEquals(3, retrievedQuestion.getAnswerList().size());

        // logger.info("Retrieved Question: id={}, subject={}, content={}, answerCount={}", 
        //     retrievedQuestion.getId(), retrievedQuestion.getSubject(), 
        //     retrievedQuestion.getContent(), retrievedQuestion.getAnswerList().size());
    }

    @Test
    void testSaveRandomAnswersToExist30Question(){                
        List<Answer> answers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            for(int j=0; j < 5; j++){
                Answer a = new Answer();
                a.setContent(generateRandomKoreanString(7));
                a.setQuestion(this.questionRepository.findById(i+1).get());
                a.setCreateDate(LocalDateTime.now());
                answers.add(a);
            }
        }
        this.answerRepository.saveAll(answers);        
    }

    @Test
    void testCreateAnswer() {
        Optional<Question> oq = this.questionRepository.findById(5);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        Answer a = new Answer();
        a.setContent("답변댓글답변답변댓글답변답변댓글답변");
        a.setQuestion(q);
        a.setCreateDate(LocalDateTime.now());
        this.answerRepository.save(a);
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
