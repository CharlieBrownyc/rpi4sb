package com.example.threadex.email.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.threadex.email.dto.EmailDto;
import com.example.threadex.email.entity.EmailStatus;
import com.example.threadex.email.repository.EmailRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final EmailRepository emailRepository;

    public void sendEmail(EmailDto emailDto) {
        
        try {
            var mimeMessage = javaMailSender.createMimeMessage();
            var helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(emailDto.getRecipient());
            helper.setSubject(emailDto.getSubject());
            helper.setText(emailDto.getContent(), true);
            
            javaMailSender.send(mimeMessage);
            
            // Optionally, save the email to the repository
            // Email email = new Email(emailDto.getRecipient(), emailDto.getSubject(), emailDto.getContent());
            // emailRepository.save(email);
        } catch (Exception e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }

    @Scheduled(fixedRate = 60000) // Every minute
    public void retryFailedEmails() {
        // Fetch emails with status FAILED and retry sending them
        var failedEmails = emailRepository.findByStatus(EmailStatus.FAILED);
        
        for (var email : failedEmails) {
            try {
                var emailDto = new EmailDto();
                emailDto.setRecipient(email.getRecipient());
                emailDto.setSubject(email.getSubject());
                emailDto.setContent(email.getContent());
                
                sendEmail(emailDto);
                
                // Update the email status to SENT after successful sending
                email.setStatus(EmailStatus.SENT);
                emailRepository.save(email);
            } catch (Exception e) {
                // Increment retry count and handle failure
                email.setRetryCount(email.getRetryCount() + 1);
                emailRepository.save(email);
            }
        }        

    }
}
