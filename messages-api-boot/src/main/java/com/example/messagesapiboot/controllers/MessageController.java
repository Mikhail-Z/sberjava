package com.example.messagesapiboot.controllers;

import com.example.messagesapiboot.infrastructure.exceptions.AppException;
import com.example.messagesapiboot.models.config.BaseSettings;
import com.example.messagesapiboot.models.dto.MessageDto;
import com.example.messagesapiboot.models.dto.MessageIdDto;
import com.example.messagesapiboot.models.dto.SettingsDto;
import com.example.messagesapiboot.providers.SettingsProvider;
import com.example.messagesapiboot.services.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping
public class MessageController {

    private final MessageService messageService;
    private final SettingsProvider settingsProvider;

    public MessageController(MessageService messageService, SettingsProvider settingsProvider) {
        this.settingsProvider = settingsProvider;
        this.messageService = messageService;
    }

    @PostMapping("saveMessage")
    public String saveMessage(@RequestBody MessageDto message) throws AppException {
        UUID messageId = messageService.save(message.toEntity());
        return messageId.toString();
    }

    @GetMapping("getMessage")
    public MessageDto getMessage(@RequestBody MessageIdDto messageId) throws AppException {
        return MessageDto.fromEntity(messageService.get(messageId.getId()));
    }

    @GetMapping("getSettings")
    public SettingsDto getSettings() {
        BaseSettings settings = settingsProvider.getSettings();
        return SettingsDto.fromEntity(settings);
    }
}
