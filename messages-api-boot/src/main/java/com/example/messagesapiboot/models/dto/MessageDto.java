package com.example.messagesapiboot.models.dto;

import com.example.messagesapiboot.models.entities.Message;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageDto {
    @JsonProperty("text_some")
    private String textSome;

    public MessageDto(@JsonProperty("text_some") String textSome) {
        this.textSome = textSome;
    }

    public String getTextSome() {
        return textSome;
    }

    public void setTextSome(String textSome) {
        this.textSome = textSome;
    }

    public static MessageDto fromEntity(Message message) {
        return new MessageDto(message.getText());
    }

    public Message toEntity() {
        return new Message(textSome);
    }
}
