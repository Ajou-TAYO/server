package com.example.ajoutayo.controller;

import com.example.ajoutayo.config.WebSocketBroadcaster;
import com.example.ajoutayo.service.WebSocketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(originPatterns = "http://localhost:8080, http://121.137.66.90:5173")
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
}
