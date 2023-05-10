package com.example.ajoutayo.controller;

import com.example.ajoutayo.dto.response.BusLocationResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/bus")
public class LocationController {

    private final SimpMessagingTemplate messagingTemplate;

    //@GetMapping("/location")
    @MessageMapping("/location")
    public void sendLocationData(@Payload BusLocationResponseDto busData) {
        // 클라이언트에게 버스 위치 정보 전송
        messagingTemplate.convertAndSend("/topic/location", busData);
    }

}