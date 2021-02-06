package com.example.messagesapiboot.controllers;

import com.example.messagesapiboot.controllers.MessageController;

import com.example.messagesapiboot.infrastructure.exceptions.AppException;
import com.example.messagesapiboot.services.MessageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@ExtendWith(SpringExtension.class)
@WebMvcTest(MessageController.class)
public class    MessageControllerIntegrationTests {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private MessageService service;

    @Test
    public void test_saveMessage_whenSuccess() throws Exception {
        UUID returnedUuid = UUID.randomUUID();
        given(service.save(Mockito.any())).willReturn(returnedUuid);
        mvc.perform(get("/getMessage").contentType(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string(returnedUuid.toString()));
    }

    @Test
    public void test_saveMessage_whenFailure() {

    }

    @Test
    public void test_getMessage_whenSuccess() {

    }

    @Test
    public void test_getMessage_whenFailure() {

    }

    @Test
    public void test_getSettings_whenSuccess() {

    }

    @Test
    public void test_getSettings_whenFailure() {

    }
}
