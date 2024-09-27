package com.example.chat_java.controller;

import com.example.chat_java.model.ChatMessage;
import com.example.chat_java.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/message")
    public ChatMessage handleMessage(@RequestBody ChatMessage chatMessage) {
        // Process the incoming message and return the response
        return chatService.processMessage(chatMessage);
    }
}
