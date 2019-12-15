package com.cgblog.blog.controller;

import com.cgblog.blog.common.ShowArticle;
import com.cgblog.blog.domain.Article;
import com.cgblog.blog.service.ArticleService;
import javafx.scene.shape.ArcTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class ArticleController {

    static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);
    @Autowired
    ArticleService service;
    @Autowired
    ShowArticle show;

    @GetMapping("/article")
    public String showArticle(@RequestParam("id")Long id, Model model){
        LOGGER.info("show article:" + id);
        show.showOne(model, id);
        return "article";
    }

    @PostMapping("/findArticle")
    public String showArticlesLike(String namelike, Model model){
        show.showPortion(model, namelike);
        return "index";
    }

    @PostMapping(value = "/manage/addArticle")
    public String addArticle(Article article,Model model){
        LOGGER.info("add article title: " + article.getTitle());
        service.saveArticle(article);
        //先插入到数据库中就会为对象赋值
        LOGGER.info("article count: " + article.getId());
        show.showAll(model);
        return "index";
    }

    @GetMapping(value = "/manage/deleteArticle")
    public String deleteArticle(@RequestParam("id") Long id, Model model){
        LOGGER.info("delete article: "+id);
        service.deleteArticle(id);
        show.showAll(model);
        return "index";
    }

    @GetMapping("/manage/toUpdateArticle")
    public String toUpdateArticle(@RequestParam("id") Long id, Model model){
        Article oldArticle = service.findArticleById(id);
        model.addAttribute("oldArticle",oldArticle);
        return "update";
    }

    @PostMapping("/manage/updateArticle")
    public String toUpdateArticle(Article article, Model model){
        LOGGER.info("update article: "+article.getId());
        Article oldArticle = service.findArticleById(article.getId());
        oldArticle.setTitle(article.getTitle());
        oldArticle.setContent(article.getContent());
        service.saveArticle(oldArticle);
        model.addAttribute("article"+oldArticle);
        return "article";
    }


}
