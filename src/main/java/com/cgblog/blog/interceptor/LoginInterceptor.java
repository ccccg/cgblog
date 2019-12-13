package com.cgblog.blog.interceptor;

import com.cgblog.blog.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginInterceptor implements HandlerInterceptor {

    static final Logger LOGGER = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws IOException {

        HttpSession session = request.getSession();
        Object obj = session.getAttribute("user");
        User user = (User) obj;


        if(user!=null&&user.getId().equals("cg123")) {
            return true;
        }
        LOGGER.info("redirect to login");
        response.sendRedirect("/toLogin");
        return false;
    }
}
