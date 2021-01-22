package com.company.chat.web;

import com.company.auth.services.AuthService;
import com.company.auth.services.implementations.CookieAuthService;
import com.company.auth.utils.AuthUtils;
import com.company.chat.model.Message;
import com.company.chat.model.User;
import com.company.chat.services.MessagesFlowManager;
import com.company.chat.services.implementations.MessagesFlowManagerImpl;
import com.company.common.exceptions.InternalServerError;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public class MessagesServlet extends HttpServlet {

    private static final String REDIRECT_LOGIN_PATH = "/auth/login";

    private static final String VIEW_PATH = "/messages.jsp";

    private final MessagesFlowManager messagesFlowManager = new MessagesFlowManagerImpl();

    private final AuthService authService = CookieAuthService.getInstance();

    public MessagesServlet() throws InternalServerError {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<User> user;
        try {
            user = validateUser(req);
        } catch (InternalServerError e) {
            req.setAttribute("errorMessage", "internal server error");
            req.getRequestDispatcher(VIEW_PATH).forward(req, resp);
            return;
        }

        if (!user.isPresent()) {
            resp.sendRedirect(req.getContextPath() + REDIRECT_LOGIN_PATH);
            return;
        }

        Collection<Message> messages = messagesFlowManager.getMessages(user.get().getId());

        if (req.getSession().getAttribute("currentUser") == null) {
            req.getSession().setAttribute("currentUser", user.get());
        }
        req.setAttribute("messages", messages);
        req.getRequestDispatcher(VIEW_PATH).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<User> user;
        try {
            user = validateUser(req);
        }
        catch (InternalServerError e) {
            req.setAttribute("errorMessage", "internal server error");
            req.getRequestDispatcher(VIEW_PATH).forward(req, resp);
            return;
        }

        if (!user.isPresent()) {
            resp.sendRedirect(req.getContextPath() + REDIRECT_LOGIN_PATH);
            return;
        }

        String newMessageText = req.getParameter("newMessage");
        Message message = new Message(newMessageText, user.get());

        try {
            messagesFlowManager.publishMessage(message);
        }
        catch (InternalServerError e) {
            req.setAttribute("errorMessage", "internal server error");
            req.getRequestDispatcher(VIEW_PATH).forward(req, resp);
            return;
        }
        resp.sendRedirect(req.getContextPath() + "/messages");
    }

    private Optional<User> validateUser(HttpServletRequest req) throws InternalServerError {
        Optional<Cookie> authCookie = AuthUtils.getAuthCookie(req);
        if (!authCookie.isPresent()) {
            return Optional.empty();
        }

        UUID userId;
        try {
            userId = UUID.fromString(authCookie.get().getValue());
        }
        catch (IllegalArgumentException e) {
            return Optional.empty();
        }

        return authService.authenticate(userId);
    }
}

