package com.cgblog.blog.controller;


import com.cgblog.blog.common.ShowArticle;
import com.cgblog.blog.domain.Article;
import com.cgblog.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    ShowArticle show;

    @GetMapping({"/","/index"})
    public String getAllArticles(Model model){
        show.showAll(model);
        show.showPage(model,0);
        return "index";
    }

    @GetMapping("/toAddArticle")
    public String toAddArticle(){
        return "add";
    }

    @GetMapping("/testRedirect")
    public String testRedirect(){
        return "redirect:/toAddArticle";
    }
}
