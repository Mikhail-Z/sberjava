package com.example.messagesapiboot.providers;

import com.example.messagesapiboot.models.config.BaseSettings;
import org.springframework.stereotype.Component;

@Component
public class SettingsProvider {

    private final BaseSettings settings;

    public SettingsProvider(BaseSettings settings) {
        this.settings = settings;
    }

    public BaseSettings getSettings() {
        return settings;
    }
}
