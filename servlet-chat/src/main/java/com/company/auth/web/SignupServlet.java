package com.company.auth.web;

import com.company.auth.exceptions.UserAlreadyExistsException;
import com.company.auth.services.AuthService;
import com.company.auth.services.implementations.CookieAuthService;
import com.company.auth.utils.AuthUtils;
import com.company.chat.model.User;
import com.company.common.exceptions.ApplicationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignupServlet extends HttpServlet {
    private final AuthService authService = CookieAuthService.getInstance();

    public SignupServlet() throws ApplicationException {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/signup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        boolean isAdmin = req.getParameter("isAdmin") != null;
        String errorMsg;
        try {
            User user = authService.signUp(login, password, isAdmin);
            req.getSession().setAttribute("currentUser", user);
            String successUrl = req.getContextPath() + "/messages";
            resp.addCookie(AuthUtils.createAuthCookie(req, user));
            resp.sendRedirect(successUrl);
        }
        catch (UserAlreadyExistsException e) {
            errorMsg = "user with such login already exists";
            req.setAttribute("errorMessage", errorMsg);
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
        catch (ApplicationException e) {
            errorMsg = "internal system error, try later...";
            req.setAttribute("errorMessage", errorMsg);
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
