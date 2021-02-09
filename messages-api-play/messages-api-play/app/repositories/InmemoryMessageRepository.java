package repositories;

import com.google.inject.Singleton;
import infrastructure.exceptions.RepositoryException;
import models.Message;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Singleton
public class InmemoryMessageRepository implements MessageRepository {
    private final Map<UUID, Message> messages = new HashMap<>();

    public void save(UUID id, Message message) throws RepositoryException {
        messages.put(id, message);
    }

    public Message get(UUID id) throws RepositoryException {
        return messages.get(id);
    }
}