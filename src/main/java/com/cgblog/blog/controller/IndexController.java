package com.cgblog.blog.controller;


import com.cgblog.blog.domain.Article;
import com.cgblog.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    ArticleService service;

    @GetMapping({"/","/index"})
    public String getAllArticles(Model model){

        List<Article> articleList = service.findAllArticle();
        System.out.println(articleList.size());
        model.addAttribute("list",articleList);
        return "index";
    }

}
