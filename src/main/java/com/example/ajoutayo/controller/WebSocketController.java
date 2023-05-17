package com.example.ajoutayo.controller;

import com.example.ajoutayo.config.WebSocketBroadcaster;
import com.example.ajoutayo.service.WebSocketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class WebSocketController {

    private final WebSocketBroadcaster webSocketBroadcaster;
    private final WebSocketService webSocketService;

    @GetMapping("/bus/location")
    public ResponseEntity<?> getLocation() {
        webSocketService.Scheduler();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/ws/test")
    public ResponseEntity<?> test(@RequestBody String message) {
        webSocketBroadcaster.broadcast(message);
        return ResponseEntity.ok().build();
    }
}
