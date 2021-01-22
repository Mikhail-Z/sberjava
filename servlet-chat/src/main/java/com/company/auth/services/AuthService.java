package com.company.auth.services;

import com.company.auth.exceptions.InvalidPasswordException;
import com.company.auth.exceptions.NoSuchUserException;
import com.company.auth.exceptions.UserAlreadyExistsException;
import com.company.chat.model.User;
import com.company.common.exceptions.InternalServerError;

import java.util.Optional;
import java.util.UUID;

public interface AuthService {
    User logIn(String login, String password) throws InvalidPasswordException, NoSuchUserException, InternalServerError;
    User signUp(String login, String password) throws UserAlreadyExistsException, InternalServerError;
    Optional<User> authenticate(UUID requestUserId) throws InternalServerError;
}
