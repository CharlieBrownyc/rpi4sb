package com.example.threadex.email.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.threadex.email.service.EmailService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
@RequestMapping("/emails")
public class EmailController {
    
    private final EmailService emailService;

    @GetMapping("/new")
    public String createForm(Model model) {
        return "email_form"; // Return the view name for creating a new email
    }
    
}
