package com.example.ajoutayo.config;

import lombok.Synchronized;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class WebSocketBroadcaster extends TextWebSocketHandler {
    private final Map<String, WebSocketSession> sessionMap = new ConcurrentHashMap<>();

    public void broadcast(String message) {
        sessionMap.values()
                .forEach(session -> {
                    try {
                        session.sendMessage(new TextMessage(message));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws IOException {
        sessionMap.put(session.getId(), session);
        session.sendMessage(new TextMessage("connected"));
    }
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        System.out.println(message);
    }
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        sessionMap.remove(session.getId());
    }
}
