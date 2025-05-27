package com.mysite.sbb.config;

import java.net.http.WebSocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.mysite.sbb.dto.MyWebSocketHandler;
import com.mysite.sbb.dto.MyWebSocketHandler2;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {

    private final WebSocketHandler webSocketHandler;
    // WebSocket 핸들러를 등록하는 메서드가 필요합니다.
    // 예를 들어, WebSocketConfigurer 인터페이스를 구현하여 핸들러를 등록할 수 있습니다.
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // registry.addHandler(webSocketHandler, "/ws").setAllowedOrigins("*");
        registry.addHandler(myHandler(), "/ws")
            .addHandler(myHandler2(), "/ws/v2").setAllowedOrigins("*");
    }

    @Bean
    public WebSocketHandler myHandler() {
        return new MyWebSocketHandler();
    }
        
    @Bean
    public WebSocketHandler myHandler2() {
        return new MyWebSocketHandler2();
    }
    
}
