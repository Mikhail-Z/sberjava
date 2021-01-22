package com.company.chat.repositories;

import com.company.chat.model.Message;
import com.company.common.exceptions.RepositoryException;

import java.util.List;

public interface MessagesRepository {
    List<Message> getAllMessages();
    void addMessage(Message message) throws RepositoryException;
}
