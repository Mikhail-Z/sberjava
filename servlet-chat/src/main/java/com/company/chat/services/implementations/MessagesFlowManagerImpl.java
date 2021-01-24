package com.company.chat.services.implementations;

import com.company.chat.model.Message;
import com.company.chat.repositories.MessagesRepository;
import com.company.chat.repositories.implementations.MessagesFileRepository;
import com.company.chat.services.MessagesFlowManager;
import com.company.common.exceptions.ApplicationException;
import com.company.common.exceptions.RepositoryException;

import java.util.List;
import java.util.UUID;

public class MessagesFlowManagerImpl implements MessagesFlowManager {

    private final MessagesRepository messagesRepository = new MessagesFileRepository();

    public MessagesFlowManagerImpl() throws RepositoryException {
    }

    @Override
    public void publishMessage(Message message) throws ApplicationException {
        try {
            messagesRepository.addMessage(message);
        }
        catch (RepositoryException e) {
            throw new ApplicationException();
        }

    }

    @Override
    public List<Message> getMessages(UUID receiverUserId) {
        return messagesRepository.getAllMessages();
    }
}
