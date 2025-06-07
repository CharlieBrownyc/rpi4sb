package com.example.multithreadex.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.multithreadex.service.SampleService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping("/test")
public class SampleController {
    
    private final SampleService sampleService;

    // http://localhost:8090/test?msg=hi
    @RequestMapping
    public String trigger(@RequestParam(defaultValue="Hello", name = "msg") String msg) {
        System.out.println("Received message: " + msg);
        sampleService.printMessage(msg);
        
        return "Test message: " + msg;
    }

}
