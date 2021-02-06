package com.example.messagesapiboot.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;


public class MessageIdDto {
    private UUID id;

    public MessageIdDto(@JsonProperty("id") UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
