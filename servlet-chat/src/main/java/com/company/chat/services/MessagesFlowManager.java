package com.company.chat.services;

import com.company.chat.model.Message;
import com.company.common.exceptions.ApplicationException;

import java.util.List;
import java.util.UUID;

public interface MessagesFlowManager {
    void publishMessage(Message message) throws ApplicationException;
    List<Message> getMessages(UUID receiverUserId);
}
