package com.cgblog.blog.common;

import com.cgblog.blog.domain.Article;
import com.cgblog.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.List;

public class ShowAllArticle {

    public static void showAll(ArticleService service, Model model){
        List<Article> articleList = service.findAllArticle();
        model.addAttribute("list",articleList);
    }

}
