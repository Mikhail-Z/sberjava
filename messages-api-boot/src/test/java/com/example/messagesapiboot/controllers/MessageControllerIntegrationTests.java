package com.example.messagesapiboot.controllers;

import com.example.messagesapiboot.infrastructure.exceptions.AppException;
import com.example.messagesapiboot.models.dto.MessageDto;
import com.example.messagesapiboot.providers.SettingsProvider;
import com.example.messagesapiboot.services.MessageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(MessageController.class)
public class    MessageControllerIntegrationTests {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private MessageService service;
    @MockBean
    SettingsProvider settingsProvider;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void test_saveMessage_whenSuccess() throws Exception {
        UUID returnedUuid = UUID.randomUUID();
        MessageDto body = new MessageDto("some text");
        given(service.save(Mockito.any())).willReturn(returnedUuid);
        mvc.perform(post("/saveMessage")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(body)))
            .andExpect(content().contentType("text/plain;charset=utf-8"))
            .andExpect(status().isOk())
            .andExpect(content().string(returnedUuid.toString()));
    }

    @Test
    public void test_saveMessage_whenFailure() throws Exception {
        MessageDto body = new MessageDto("some text");
        given(service.save(Mockito.any())).willThrow(new AppException());
        mvc.perform(post("/saveMessage")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(body)))
            .andExpect(status().isInternalServerError());
    }
}
