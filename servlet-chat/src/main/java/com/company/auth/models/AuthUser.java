package com.company.auth.models;

import java.io.Serializable;
import java.util.UUID;

public class AuthUser implements Serializable {
    private final UUID id = UUID.randomUUID();
    private final String login;
    private final String password;

    public AuthUser(String login, String password) {
        this.login = login;
        this.password = password;
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
}
