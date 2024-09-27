package com.example.chat_java.service;

import org.springframework.stereotype.Service;

import com.example.chat_java.model.ChatMessage;
import com.example.chat_java.model.Content;

@Service
public class ChatService {

    public ChatMessage processMessage(ChatMessage message) {

        String userMessage = message.getContent().getMessage();

        String response = "AI response: " + userMessage;

        Content responseContent = new Content();
        responseContent.setMessage(response);

        ChatMessage responChatMessage = new ChatMessage();

        responChatMessage.setRole("AI");
        responChatMessage.setContent(responseContent);

        return responChatMessage;
    }
}
