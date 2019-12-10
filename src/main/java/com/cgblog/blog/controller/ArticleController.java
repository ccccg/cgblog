package com.cgblog.blog.controller;

import com.cgblog.blog.domain.Article;
import com.cgblog.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @Autowired
    ArticleService service;

    @PostMapping(value = "/addArticle")
    public String addArticle(Article article,Model model){
        System.out.println(article.getTitle());
        service.saveArticle(article);
        model.addAttribute("list",service.findAllArticle());
        return "index";
    }
}
