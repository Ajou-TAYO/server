package com.example.ajoutayo.controller;

import com.example.ajoutayo.config.WebSocketBroadcaster;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.IntStream;

@RequiredArgsConstructor
@RestController
public class WebSocketController {

    private final WebSocketBroadcaster webSocketBroadcaster;
    @GetMapping("/ws/run")
    public ResponseEntity<?> run() {
        IntStream.range(0, 100)
                .forEach(n -> new Thread(() -> webSocketBroadcaster.broadcast("message: " + n)).start());

        return ResponseEntity.ok().build();
    }
    @PostMapping("/ws/test")
    public ResponseEntity<?> test(@RequestBody String message) {
        webSocketBroadcaster.broadcast(message);
        return ResponseEntity.ok().build();
    }
}
