package com.example.chat_java.model;

public class Content {

    private String message; // Actual content (could be text, URL, etc.)

    // Constructors
    public Content() {
    }

    public Content(String message) {

        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;

    }

}
