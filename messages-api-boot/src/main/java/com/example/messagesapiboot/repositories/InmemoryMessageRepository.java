package com.example.messagesapiboot.repositories;

import com.example.messagesapiboot.models.dto.MessageDto;
import com.example.messagesapiboot.models.entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
@Profile("local")
public class InmemoryMessageRepository implements MessageRepository {
    private final Map<UUID, Message> messages = new HashMap<>();
    //@Resource
    //public Environment environment;
    public void save(UUID id, Message message) {
        //String env = this.environment.getProperty("spring.profiles.active");
        messages.put(id, message);
    }

    public Message get(UUID id) throws IllegalArgumentException {
        return messages.get(id);
    }
}
