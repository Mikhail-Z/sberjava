package com.company.chat.repositories.implementations;

import com.company.chat.model.Message;
import com.company.chat.repositories.MessagesRepository;
import com.company.common.exceptions.RepositoryException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MessagesFileRepository implements MessagesRepository {
    private final List<Message> messages;

    private final String fileName = "messages.bin";

    public MessagesFileRepository() throws RepositoryException  {
        try {
            if (!createFileIfNotExists()) {
                messages = readMessages();
            }
            else {
                messages = new ArrayList<>();
            }
        }
        catch (IOException | ClassNotFoundException e) {
            throw new RepositoryException();
        }
    }

    public synchronized List<Message> getAllMessages() {
        return messages;
    }

    public synchronized void addMessage(Message message) throws RepositoryException {
        messages.add(message);
        try {
            writeMessagesToFile();
        }
        catch(IOException e) {
            throw new RepositoryException();
        }
    }

    private ArrayList<Message> readMessages() throws IOException, ClassNotFoundException {
        ArrayList<Message> messages;
        try {
            try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
                try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                    int count = objectInputStream.readInt();
                    messages = new ArrayList<>(count);
                    for (int i = 0; i < count; i++) {
                        messages.add((Message) objectInputStream.readObject());
                    }
                }
            }
        } catch (EOFException e) {
            return new ArrayList<>();
        }

        return messages;
    }

    private void writeMessagesToFile() throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                objectOutputStream.writeInt(messages.size());
                for (Message message : messages) objectOutputStream.writeObject(message);
            }
        }
    }

    private boolean createFileIfNotExists() throws IOException {
        return new File(fileName).createNewFile();
    }
}
