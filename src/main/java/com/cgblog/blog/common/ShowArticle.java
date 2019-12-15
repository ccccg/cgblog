package com.cgblog.blog.common;

import com.cgblog.blog.domain.Article;
import com.cgblog.blog.domain.Comment;
import com.cgblog.blog.service.ArticleService;
import com.cgblog.blog.service.ArticleServiceImpl;
import com.cgblog.blog.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.List;
@Component
public class ShowArticle {
    static final Logger LOGGER = LoggerFactory.getLogger(ShowArticle.class);
    @Autowired
    ArticleService articleService;
    @Autowired
    CommentService commentService;

    public ShowArticle() {

    }

    public void showPortion(Model model, String namelike){
        List<Article> articleList = articleService.findArticleByNameLike(namelike);
        model.addAttribute("list",articleList);
    }

    public void showAll(Model model){
        System.out.println(articleService==null);
        List<Article> articleList = articleService.findAllArticle();
        model.addAttribute("list",articleList);
    }

    public void showOne(Model model, Long id){
        Article article = articleService.findArticleById(id);
        model.addAttribute("article" ,article);
        List<Comment> comments = commentService.showAllComment(id);
        LOGGER.info("comment size: " + comments.size());
        model.addAttribute("comments",comments);
    }

}
