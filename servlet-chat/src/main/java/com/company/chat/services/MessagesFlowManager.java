package com.company.chat.services;

import com.company.chat.model.Message;
import com.company.common.exceptions.InternalServerError;

import java.util.List;
import java.util.UUID;

public interface MessagesFlowManager {
    void publishMessage(Message message) throws InternalServerError;
    List<Message> getMessages(UUID receiverUserId);
}
