package com.example.messagesapiboot.models.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
    private String text;

    public Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
