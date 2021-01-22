package com.company.common;

import com.company.auth.models.AuthUser;
import com.company.auth.repositories.implementations.UsersFileRepository;
import com.company.chat.model.Message;
import com.company.chat.model.User;
import com.company.chat.repositories.MessagesRepository;
import com.company.chat.repositories.implementations.MessagesFileRepository;
import com.company.common.exceptions.RepositoryException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws RepositoryException {
        AuthUser authUser = new AuthUser("login", "password");
        /*UsersFileRepository usersRepository = new UsersFileRepository();
        usersRepository.save(authUser);
        Optional<AuthUser> user = usersRepository.findByLogin("login");
        System.out.println(user.get().getLogin());*/

        MessagesRepository messagesRepository = new MessagesFileRepository();
        //messagesRepository.addMessage(new Message("text 1", new User(authUser)));
        //messagesRepository.addMessage(new Message("text 2", new User(authUser)));
        List<Message> messages = messagesRepository.getAllMessages();
        System.out.println(messages.size());
        //messagesRepository.addMessage(new Message("some text 2", UUID.randomUUID()));*/
    }
}
