package com.mysite.sbb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableAsync
@EnableScheduling
public class ScheduledTask {
    
    @Async
    @Scheduled(fixedDelay = 10000) // 1초마다 실행
    public void scheduledTask() {
        // 여기에 실행할 작업을 작성합니다.
        System.out.println("Scheduled task is running..."+Thread.currentThread().getName());
        
    }
}
