package com.cgblog.blog.controller;

import com.cgblog.blog.domain.Article;
import com.cgblog.blog.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/manage")
public class ArticleController {

    static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);
    @Autowired
    ArticleService service;

    @PostMapping(value = "/addArticle")
    public String addArticle(Article article,Model model){
        System.out.println(article.getTitle());

        service.saveArticle(article);
        //先插入到数据库中就会为对象赋值
        System.out.println(article.getId());
        model.addAttribute("list",service.findAllArticle());
        return "index";
    }

    @GetMapping(value = "/deleteArticle/{id}")
    public String deleteArticle(@PathVariable("id") Long id, Model model){
        LOGGER.info("delete article: "+id);
        service.deleteArticle(id);
        model.addAttribute("list",service.findAllArticle());
        return "index";
    }

}
