package com.company.chat.repositories.implementations;

import com.company.chat.model.Message;
import com.company.chat.repositories.MessagesRepository;

import java.util.ArrayList;
import java.util.List;

public class MessagesInmemoryRepository implements MessagesRepository {
    private final List<Message> messages = new ArrayList<>();

    public List<Message> getAllMessages() {
        return messages;
    }

    public void addMessage(Message message) {
        messages.add(message);
    }
}
