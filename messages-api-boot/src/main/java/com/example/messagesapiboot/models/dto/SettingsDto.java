package com.example.messagesapiboot.models.dto;

import com.example.messagesapiboot.models.config.BaseSettings;

public class SettingsDto {

    private final String value;

    public SettingsDto(String value) {
        this.value = value;
    }

    public static SettingsDto fromEntity(BaseSettings setting) {
        return new SettingsDto(setting.getValue());
    }

    public String getValue() {
        return value;
    }
}
