package com.company.chat.model;

import com.company.auth.models.AuthUser;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {
    private final UUID id;
    private final String name;

    public User(AuthUser user) {
        id = user.getId();
        name = user.getLogin();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
