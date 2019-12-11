package com.cgblog.blog.service;

import com.cgblog.blog.domain.Article;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ArticleService {
    List findAllArticle();

    Article saveArticle(Article article);

    void deleteArticle(Long id);
}
