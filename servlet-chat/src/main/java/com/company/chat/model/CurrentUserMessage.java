package com.company.chat.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class CurrentUserMessage {
    private final String text;
    private final UUID id;
    private final User senderUser;
    private final LocalDateTime createDt;
    private final boolean isMessageFromCurrentUser;

    public CurrentUserMessage(Message message, User currentUser) {
        this.text = message.getText();
        this.senderUser = message.getSenderUser();
        this.id = message.getId();
        this.createDt = message.getCreateDt();
        this.isMessageFromCurrentUser = currentUser.getId().equals(senderUser.getId());
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

    public boolean isMessageFromCurrentUser() {
        return isMessageFromCurrentUser;
    }
}
