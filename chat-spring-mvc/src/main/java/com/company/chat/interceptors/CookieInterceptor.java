package com.company.chat.interceptors;

import com.company.utils.AuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import java.util.UUID;

public class CookieInterceptor implements HandlerInterceptor {
    private static final Logger LOG = LoggerFactory.getLogger(CookieInterceptor.class);

    private static final String LOGIN_URL_SEGMENT = "/auth/login";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOG.info("in cookie interceptor before");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LOG.info("in cookie interceptor after controller return");
        Optional<Cookie> authCookie = AuthUtils.getAuthCookie(request);
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
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LOG.info("in cookie interceptor after view generating");
    }
}
