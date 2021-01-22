package com.company.auth.repositories.implementations;

import com.company.common.exceptions.RepositoryException;
import com.company.auth.models.AuthUser;
import com.company.auth.repositories.AuthUsersRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UsersFileRepository implements AuthUsersRepository {

    private final List<AuthUser> users;

    private final String fileName = "users.bin";

    public UsersFileRepository() throws RepositoryException {

        try {
            if (!createFileIfNotExists()) users = readUsers();
            else users = new ArrayList<>();
        }
        catch (IOException | ClassNotFoundException e) {
            throw new RepositoryException();
        }
    }

    @Override
    public void save(AuthUser user) throws RepositoryException {
        users.add(user);
        try {
            writeUsersToFile();
        }
        catch (IOException e) {
            throw new RepositoryException();
        }
    }

    @Override
    public Optional<AuthUser> findByLogin(String login) throws RepositoryException {
       return users.stream()
               .filter(u -> u.getLogin().equals(login))
               .findFirst();
    }

    @Override
    public Optional<AuthUser> findByUserId(UUID userId) throws RepositoryException {
            return users.stream()
                    .filter(u -> u.getId().equals(userId))
                    .findFirst();
    }

    private ArrayList<AuthUser> readUsers() throws IOException, ClassNotFoundException {
        ArrayList<AuthUser> readUsers;
        try {
            try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
                try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                    int count = objectInputStream.readInt();
                    readUsers = new ArrayList<>(count);
                    for (int i = 0; i < count; i++) {
                        readUsers.add((AuthUser)objectInputStream.readObject());
                    }
                }
            }
        }
        catch (EOFException e) {
            return new ArrayList<>();
        }

        return readUsers;
    }

    private void writeUsersToFile() throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                objectOutputStream.writeInt(users.size());
                for (AuthUser user : users) objectOutputStream.writeObject(user);
            }
        }
    }

    private boolean createFileIfNotExists() throws IOException {
        return new File(fileName).createNewFile();
    }
}
