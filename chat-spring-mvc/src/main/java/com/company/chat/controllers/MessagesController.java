package com.company.chat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessagesController {
    @GetMapping("/messages")
    public String Messages() {
        return "messages/messages";
    }
}
