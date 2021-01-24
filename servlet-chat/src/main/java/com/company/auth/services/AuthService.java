package com.company.auth.services;

import com.company.auth.exceptions.InvalidPasswordException;
import com.company.auth.exceptions.NoSuchUserException;
import com.company.auth.exceptions.UserAlreadyExistsException;
import com.company.chat.model.User;
import com.company.common.exceptions.ApplicationException;

import java.util.Optional;
import java.util.UUID;

public interface AuthService {
    User logIn(String login, String password) throws InvalidPasswordException, NoSuchUserException, ApplicationException;
    User signUp(String login, String password, boolean isAdmin) throws UserAlreadyExistsException, ApplicationException;
    Optional<User> authenticate(UUID requestUserId) throws ApplicationException;
}
