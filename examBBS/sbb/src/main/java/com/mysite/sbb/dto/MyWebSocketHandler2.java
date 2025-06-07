package com.mysite.sbb.dto;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


public class MyWebSocketHandler2 extends TextWebSocketHandler{

    private static final ConcurrentHashMap<String, WebSocketSession> clients = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // 클라이언트가 연결되었을 때 호출되는 메서드
        String sessionId = session.getId();
        System.out.println("Client connected: " + sessionId);
        clients.put(sessionId, session);
        
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // 클라이언트가 연결을 종료했을 때 호출되는 메서드
        String sessionId = session.getId();
        clients.remove(sessionId);
        System.out.println("Client disconnected: " + sessionId);
    }

    @Override
    public void handleTextMessage(WebSocketSession session, org.springframework.web.socket.TextMessage message) throws Exception {
        // 클라이언트로부터 메시지를 받았을 때 호출되는 메서드
        String sessionId = session.getId();
        System.out.println("Received message from " + sessionId + ": " + message.getPayload());
        
        // 예시: 모든 클라이언트에게 메시지 브로드캐스트
        for (WebSocketSession client : clients.values()) {
            if (client.isOpen()) {
                // client.sendMessage(new org.springframework.web.socket.TextMessage("Echo: " + message.getPayload()));
                sendMessageToClient("Echo: " + message.getPayload());
            }
        }
    }
        
    @Async("threadPoolTaskExecutor")
    public void sendMessageToClient(String message) {
        // 특정 클라이언트에게 메시지를 보내는 메서드
        for (WebSocketSession client : clients.values()) {
            if (client != null && client.isOpen()) {
                try {
                    client.sendMessage(new org.springframework.web.socket.TextMessage(message+ "/thread: " + Thread.currentThread().getName()));
                } catch (IOException e) {                    
                    e.printStackTrace();
                }
            }
        }        
    }


}
