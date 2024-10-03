package com.example.chat_java.controller;

import com.example.chat_java.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from the frontend origin
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/chat")
    public Map<String, String> getCompletion(
            @RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        // Correctly reference chatService (the instance) instead of ChatService (the
        // class name)
        String aiResponse = chatService.getAIResponse(message);

        // Return the response from the service
        return Map.of("completion", aiResponse);
    }
}
