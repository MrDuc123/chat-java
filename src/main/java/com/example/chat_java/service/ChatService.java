package com.example.chat_java.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatClient chatClient;

    public ChatService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String getAIResponse(String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }
}