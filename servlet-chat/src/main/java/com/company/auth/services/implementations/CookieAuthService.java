package com.company.auth.services.implementations;

import com.company.auth.exceptions.InvalidPasswordException;
import com.company.auth.exceptions.NoSuchUserException;
import com.company.auth.exceptions.UserAlreadyExistsException;
import com.company.auth.models.AuthUser;
import com.company.auth.repositories.AuthUsersRepository;
import com.company.auth.repositories.implementations.UsersFileRepository;
import com.company.auth.services.AuthService;
import com.company.chat.model.User;
import com.company.common.exceptions.ApplicationException;
import com.company.common.exceptions.RepositoryException;

import java.util.Optional;
import java.util.UUID;

public class CookieAuthService implements AuthService {
    private static CookieAuthService authService;

    private final AuthUsersRepository usersRepository = new UsersFileRepository();

    private CookieAuthService() throws RepositoryException {}

    public static synchronized CookieAuthService getInstance() throws ApplicationException {
        if (authService == null) {
            authService = new CookieAuthService();
        }

        return authService;
    }

    @Override
    public User logIn(String login, String password) throws InvalidPasswordException, NoSuchUserException, ApplicationException {
        Optional<AuthUser> authUser = usersRepository.findByLogin(login);

        if (!authUser.isPresent()) throw new NoSuchUserException();

        if (!authUser.get().getPassword().equals(password)) throw new InvalidPasswordException();

        return new User(authUser.get());
    }

    @Override
    public User signUp(String login, String password, boolean isAdmin) throws UserAlreadyExistsException, ApplicationException {

        Optional<AuthUser> user = usersRepository.findByLogin(login) ;

        if (user.isPresent()) throw new UserAlreadyExistsException();

        AuthUser newUser = new AuthUser(login, password, isAdmin);
        usersRepository.save(newUser);

        return new User(newUser);
    }

    @Override
    public Optional<User> authenticate(UUID cookieUserId) throws RepositoryException {

        return usersRepository.findByUserId(cookieUserId).map(User::new);
    }
}
