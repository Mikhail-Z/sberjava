package repositories;

import com.google.inject.ImplementedBy;
import com.google.inject.Singleton;
import infrastructure.exceptions.RepositoryException;
import models.Message;

import java.util.UUID;

@ImplementedBy(InmemoryMessageRepository.class)
public interface MessageRepository {
    void save(UUID id, Message message) throws RepositoryException;
    Message get(UUID id) throws RepositoryException;
}
