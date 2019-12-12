package com.cgblog.blog.controller;


import com.cgblog.blog.domain.User;
import com.cgblog.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/regist")
    public String regist(User user){
        userService.save(user);
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, Model model,
                        HttpServletRequest req, HttpServletResponse res){
        User newUser = userService.login(user.getId(),user.getPassword());
        HttpSession session = req.getSession();
        session.setAttribute("user",newUser);
        if(newUser!=null){
            model.addAttribute("user",newUser);
            return "index";
        }else{
            String error = "loginfail";
            model.addAttribute("error",error);
            return "login";
        }
    }
}
