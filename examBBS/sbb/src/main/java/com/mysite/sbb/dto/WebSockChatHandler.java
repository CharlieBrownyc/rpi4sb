package com.mysite.sbb.dto;

import java.io.IOException;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysite.sbb.service.ChatService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class WebSockChatHandler extends TextWebSocketHandler {
    // WebSocket 핸들러의 구현이 필요합니다.
    // 예를 들어, WebSocketHandler 인터페이스를 구현하여 메시지를 처리할 수 있습니다.
    // 이 클래스는 WebSocket 연결을 관리하고, 클라이언트와의 메시지를 주고받는 로직을 포함해야 합니다.
    private final ObjectMapper objectMapper;
    private final ChatService chatService;

    // 예시로, 메시지를 수신하고 브로드캐스트하는 메서드를 추가할 수 있습니다.
    // public void handleMessage(WebSocketSession session, String message) {
    //     // 메시지 처리 로직
    // }
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);
        ChatRoom room = chatService.findRoomById(chatMessage.getRoomId());
        Set<WebSocketSession> sessions=room.getSessions();   //방에 있는 현재 사용자 한명이 WebsocketSession
        if (chatMessage.getType().equals(ChatMessage.MessageType.ENTER)) {
            //사용자가 방에 입장하면  Enter메세지를 보내도록 해놓음.  이건 새로운사용자가 socket 연결한 것이랑은 다름.
            //socket연결은 이 메세지 보내기전에 이미 되어있는 상태
            sessions.add(session);
            chatMessage.setMessage(chatMessage.getSender() + "님이 입장했습니다.");  //TALK일 경우 msg가 있을 거고, ENTER일 경우 메세지 없으니까 message set
            sendToEachSocket(sessions,new TextMessage(objectMapper.writeValueAsString(chatMessage)) );
        }else if (chatMessage.getType().equals(ChatMessage.MessageType.QUIT)) {
            sessions.remove(session);
            chatMessage.setMessage(chatMessage.getSender() + "님이 퇴장했습니다..");
            sendToEachSocket(sessions,new TextMessage(objectMapper.writeValueAsString(chatMessage)) );
        }else {
            sendToEachSocket(sessions,message ); //입장,퇴장 아닐 때는 클라이언트로부터 온 메세지 그대로 전달.
        }
    }
    // 또한, 연결이 열리거나 닫힐 때의 이벤트를 처리하는 메서드도 필요할 수 있습니다.
    // public void afterConnectionEstablished(WebSocketSession session) {
    //     // 연결이 열렸을 때의 로직
    // }
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

    }
        
    private  void sendToEachSocket(Set<WebSocketSession> sessions, TextMessage message){
        sessions.parallelStream().forEach( roomSession -> {
            try {
                roomSession.sendMessage(message);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    
    // public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
    //     // 연결이 닫혔을 때의 로직
    // }
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
       //javascript에서  session.close해서 연결 끊음. 그리고 이 메소드 실행.
        //session은 연결 끊긴 session을 매개변수로 이거갖고 뭐 하세요.... 하고 제공해주는 것 뿐
    }
}
