package com.company.auth.filters;

import com.company.auth.utils.AuthUtils;
import com.company.chat.model.User;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

public class CookieFilter implements Filter {
    private static final String AUTH_COOKIE_NAME = "yet-another-chat-userId";
    private static final String LOGIN_URL_SEGMENT = "/auth/login";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        Optional<Cookie> authCookie = AuthUtils.getAuthCookie(httpReq);
        if (!authCookie.isPresent()) {
            request.getRequestDispatcher(LOGIN_URL_SEGMENT).forward(request, response);
            return;
        }

        try {
            UUID.fromString(authCookie.get().getValue());
        }
        catch (IllegalArgumentException e) {
            request.getRequestDispatcher(LOGIN_URL_SEGMENT).forward(request, response);
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
