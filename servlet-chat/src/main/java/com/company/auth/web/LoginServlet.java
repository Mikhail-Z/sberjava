package com.company.auth.web;

import com.company.auth.exceptions.InvalidPasswordException;
import com.company.auth.exceptions.NoSuchUserException;
import com.company.auth.services.AuthService;
import com.company.auth.services.implementations.CookieAuthService;
import com.company.auth.utils.AuthUtils;
import com.company.chat.model.User;
import com.company.common.exceptions.InternalServerError;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private final AuthService authService = CookieAuthService.getInstance();
    private static final String VIEW_PATH = "/login.jsp";

    public LoginServlet() throws InternalServerError {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(VIEW_PATH).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        try {
            User user = authService.logIn(login, password);
            req.getSession().setAttribute("currentUser", user);
            String successUrl = req.getContextPath() + "/messages";
            resp.addCookie(AuthUtils.createAuthCookie(req, user));
            resp.sendRedirect(successUrl);
            return;
        }
        catch (InvalidPasswordException e) {
            req.setAttribute("errorMessage", "invalid password");
            req.getRequestDispatcher(VIEW_PATH).forward(req, resp);
        }
        catch (NoSuchUserException e) {
            req.setAttribute("errorMessage", "no such user");
            req.getRequestDispatcher(VIEW_PATH).forward(req, resp);
        } catch (InternalServerError internalServerError) {
            req.setAttribute("errorMessage", "internal server error");
            req.getRequestDispatcher(VIEW_PATH).forward(req, resp);
        }
    }
}
