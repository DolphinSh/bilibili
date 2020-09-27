package com.charon.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object token = session.getAttribute("token");
        if (token == null) {
            request.getRequestDispatcher("/auth/login/index.html").forward(request, response);
            return false;
        }
        return true;
    }
}
