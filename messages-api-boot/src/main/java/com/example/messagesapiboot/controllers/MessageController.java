package com.example.messagesapiboot.controllers;

import com.example.messagesapiboot.infrastructure.exceptions.AppException;
import com.example.messagesapiboot.models.config.BaseSettings;
import com.example.messagesapiboot.models.dto.MessageDto;
import com.example.messagesapiboot.models.dto.MessageIdDto;
import com.example.messagesapiboot.models.dto.SettingsDto;
import com.example.messagesapiboot.providers.SettingsProvider;
import com.example.messagesapiboot.services.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> saveMessage(@RequestBody MessageDto message) throws AppException {
        try {
            UUID messageId = messageService.save(message.toEntity());
            return ResponseEntity.ok(messageId.toString());
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("getMessage/{id}")
    public ResponseEntity<MessageDto> getMessage(@RequestParam("id") String messageId) throws AppException {
        try {
            return ResponseEntity.ok(MessageDto.fromEntity(messageService.get(messageId)));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("getSettings")
    public SettingsDto getSettings() {
        BaseSettings settings = settingsProvider.getSettings();
        return SettingsDto.fromEntity(settings);
    }
}
