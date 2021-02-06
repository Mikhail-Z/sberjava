package com.example.messagesapiboot.repositories;

import com.example.messagesapiboot.infrastructure.exceptions.RepositoryException;
import com.example.messagesapiboot.models.dto.MessageDto;
import com.example.messagesapiboot.models.entities.Message;

import java.util.UUID;

public interface MessageRepository {
    void save(UUID id, Message message) throws RepositoryException;
    Message get(UUID id) throws RepositoryException;
}
