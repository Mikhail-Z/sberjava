package com.company.auth.filters;

import com.company.auth.utils.AuthUtils;
import com.company.chat.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        User currentUser = (User)httpReq.getSession().getAttribute("currentUser");
        if (!currentUser.isAdmin()) {
            request.getRequestDispatcher("/messages").forward(request, response);
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
