package com.company.chat.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public class Message implements Serializable {

    private final String text;
    private final UUID id = UUID.randomUUID();
    private final LocalDateTime createDt = LocalDateTime.now();
    private final User senderUser;

    public Message(String text, User senderUser) {
        this.text = text;
        this.senderUser = senderUser;
    }

    public String getText() {
        return text;
    }

    public UUID getId() {
        return id;
    }

    public User getSenderUser() {
        return senderUser;
    }

    public LocalDateTime getCreateDt() {
        return createDt;
    }
}