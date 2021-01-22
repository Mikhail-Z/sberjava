package com.company.auth.repositories;

import com.company.common.exceptions.RepositoryException;
import com.company.auth.models.AuthUser;

import java.util.Optional;
import java.util.UUID;

public interface AuthUsersRepository {
    void save(AuthUser user) throws RepositoryException;
    Optional<AuthUser> findByLogin(String login) throws RepositoryException;

    Optional<AuthUser> findByUserId(UUID userId) throws RepositoryException;
}
