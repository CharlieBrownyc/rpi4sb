package com.mysite.sbb.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mysite.sbb.DataNotFoundException;
import com.mysite.sbb.entity.Question;
import com.mysite.sbb.repository.QuestionRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public Page<Question> getList(int page){
        List<Sort.Order> sorts = new ArrayList<>(); // Create a list to hold sorting orders
        sorts.add(Sort.Order.desc("createDate")); // Add sorting by createDate in descending order
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts)); // Create a Pageable object with the specified page number, size, and sorting
        return this.questionRepository.findAll(pageable); // Retrieve a paginated list of questions sorted by createDate in descending order
    }

    public List<Question> getList(){ // Method to retrieve all questions without pagination
        return questionRepository.findAll();
    }

    public Question getQuestion(Integer id){
        Optional<Question> question = this.questionRepository.findById(id);
        if(question.isPresent()){
            return question.get();
        }else{
            throw new DataNotFoundException("question not found");
        }
    }

    public void create(String subject, String content){
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q);
    }
}
