package com.company.utils;

import com.company.chat.models.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;

public class AuthUtils {
    private static final String AUTH_COOKIE_NAME = "yet-another-chat-userId";
    private static final String AUTH_COOKIE_SEGMENT_PATH = "/messages";

    public static Optional<Cookie> getAuthCookie(HttpServletRequest req) {
        if (req.getCookies() == null) return Optional.empty();

        return Arrays.stream(req.getCookies())
                .filter(c -> c.getName().equals(AuthUtils.AUTH_COOKIE_NAME))
                .findFirst();
    }

    public static Cookie createAuthCookie(HttpServletRequest req, User user) {
        Cookie cookie = new Cookie(AUTH_COOKIE_NAME, user.getId().toString());
        cookie.setPath(req.getContextPath() + AUTH_COOKIE_SEGMENT_PATH);
        return cookie;
    }
}
