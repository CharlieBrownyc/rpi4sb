package com.example.multithreadex.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class SampleService {
    private static final Logger log = LoggerFactory.getLogger(SampleService.class);


    @Async("threadPoolTaskExecutor")
    public void printMessage(String message) {
        log.info("execute thread: {}", Thread.currentThread().getName());
        try {
            // Simulate a long-running task
            Thread.sleep(2000);
            log.info("printMessage method executed in thread: {}", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("printMessage method interrupted: {}", e.getMessage());
        }
        log.info("message complete: {}", message);
    }
}
