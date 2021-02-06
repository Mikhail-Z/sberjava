package com.company.chat.models;

import com.company.auth.models.AuthUser;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {
    private final UUID id;
    private final String name;
    private final boolean isAdmin;

    public User(AuthUser user) {
        id = user.getId();
        name = user.getLogin();
        isAdmin = user.isAdmin();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
