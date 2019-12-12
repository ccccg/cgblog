package com.cgblog.blog.controller;

import com.cgblog.blog.domain.Article;
import com.cgblog.blog.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RouteController {

    static final Logger LOGGER = LoggerFactory.getLogger(RouteController.class);

    @GetMapping("/toRegist")
    public String toRegist(){
        LOGGER.info("route to regist");
        return "regist";
    }
    @GetMapping("/toLogin")
    public String toLogin(){
        LOGGER.info("route to login");
        return "login";
    }



}
