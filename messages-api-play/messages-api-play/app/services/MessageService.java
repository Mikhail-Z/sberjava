package services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import infrastructure.exceptions.AppException;
import infrastructure.exceptions.RepositoryException;
import models.Message;
import repositories.InmemoryMessageRepository;
import repositories.MessageRepository;

import java.util.UUID;

@Singleton
public class MessageService {

    private final MessageRepository repo;

    @Inject
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