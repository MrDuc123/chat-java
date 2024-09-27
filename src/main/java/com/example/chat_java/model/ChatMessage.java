package com.example.chat_java.model;

public class ChatMessage {
    private String role;
    private Content content;

    public ChatMessage() {
    }

    public ChatMessage(String role, Content content) {
        this.role = role;
        this.content = content;
    }

    // Getters and Setters
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
}