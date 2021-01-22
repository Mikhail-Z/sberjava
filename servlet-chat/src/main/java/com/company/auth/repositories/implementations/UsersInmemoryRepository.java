package com.company.auth.repositories.implementations;

import com.company.auth.repositories.AuthUsersRepository;
import com.company.auth.models.AuthUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UsersInmemoryRepository implements AuthUsersRepository {

    private final List<AuthUser> users = new ArrayList<>();

    @Override
    public synchronized void save(AuthUser user) {
        users.add(user);
    }

    @Override
    public synchronized Optional<AuthUser> findByLogin(String login) {
        return users.stream()
                .filter(u -> u.getLogin().equals(login))
                .findFirst();
    }

    @Override
    public synchronized Optional<AuthUser> findByUserId(UUID userId) {
        return users.stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst();
    }
}
