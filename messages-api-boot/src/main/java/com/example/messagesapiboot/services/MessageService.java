package com.example.messagesapiboot.services;

import com.example.messagesapiboot.infrastructure.exceptions.AppException;
import com.example.messagesapiboot.infrastructure.exceptions.RepositoryException;
import com.example.messagesapiboot.models.dto.MessageDto;
import com.example.messagesapiboot.models.entities.Message;
import com.example.messagesapiboot.repositories.InmemoryMessageRepository;
import com.example.messagesapiboot.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MessageService {

    private final MessageRepository repo;

    public MessageService(MessageRepository messageRepository) {
        repo = messageRepository;
    }

    public UUID save(Message message) throws AppException {
        UUID messageId = UUID.randomUUID();
        try {
            repo.save(messageId, message);
            return messageId;
        }
        catch (RepositoryException e) {
            throw new AppException();
        }
    }

    public Message get(UUID messageId) throws AppException {
        try {
            return repo.get(messageId);
        }
        catch (RepositoryException e) {
            throw new AppException();
        }
    }
}
