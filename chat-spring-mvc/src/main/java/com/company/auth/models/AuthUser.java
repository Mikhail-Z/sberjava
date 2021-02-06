package com.company.auth.models;

import java.io.Serializable;
import java.util.UUID;

public class AuthUser implements Serializable {
    private final UUID id = UUID.randomUUID();
    private final String login;
    private final String password;
    private final boolean isAdmin;

    public AuthUser(String login, String password, boolean isAdmin) {
        this.login = login;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public UUID getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
