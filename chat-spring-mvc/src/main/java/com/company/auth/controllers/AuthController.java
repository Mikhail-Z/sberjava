package com.company.auth.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(path = "/auth")
public class AuthController {
    private final AuthService authService = CookieAuthService.getInstance();
    private static final String VIEW_PATH = "/login.jsp";

    @GetMapping("/login")
    public String login(HttpServletRequest req) {
        return redire
    }

    @PostMapping("/login")
    public String login(HttpServletRequest req) {

    }

    @GetMapping("/signup")
    public String signup(HttpServletRequest req) {

    }

    @PostMapping("/signup")
    public String signup(HttpServletRequest req) {

    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest req) {

    }

}
