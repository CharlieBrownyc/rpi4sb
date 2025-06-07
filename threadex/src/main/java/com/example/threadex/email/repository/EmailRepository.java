package com.example.threadex.email.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.threadex.email.entity.Email;
import com.example.threadex.email.entity.EmailStatus;

public interface EmailRepository extends JpaRepository<Email, Long> {
    // Additional query methods can be defined here if needed

    List<Email> findByStatus(EmailStatus status);
    
}
