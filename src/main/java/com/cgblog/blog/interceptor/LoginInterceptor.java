package com.cgblog.blog.interceptor;

import com.cgblog.blog.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws IOException {

        HttpSession session = request.getSession();
        Object obj = session.getAttribute("user");
        User user = (User) obj;
        if(user!=null&&user.getId() == "cg123") {
            return true;
        }
        response.sendRedirect("/toLogin");
        return false;
    }
}
