package com.example.messagesapiboot.repositories;

import com.example.messagesapiboot.infrastructure.exceptions.RepositoryException;
import com.example.messagesapiboot.models.dto.MessageDto;
import com.example.messagesapiboot.models.entities.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
@Profile("test")
public class FileMessageRepository implements MessageRepository {

    private final Map<UUID, Message> messages = new HashMap<>();
    private static final Logger LOG = LoggerFactory.getLogger(FileMessageRepository.class);

    @Override
    public void save(UUID id, Message message) throws RepositoryException {
        messages.put(id, message);
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(Paths.get("messages.json").toFile(), messages);
        }
        catch (IOException e) {
            LOG.error(e.getMessage());
            throw new RepositoryException();
        }
    }

    @Override
    public Message get(UUID id) throws RepositoryException {
        return messages.get(id);
    }
}
