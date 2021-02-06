package com.example.messagesapiboot.models.dto;

import com.example.messagesapiboot.models.entities.Message;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageDto {
    private String text;

    public MessageDto(@JsonProperty("text") String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static MessageDto fromEntity(Message message) {
        return new MessageDto(message.getText());
    }

    public Message toEntity() {
        return new Message(text);
    }
}
