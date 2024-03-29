package com.cgblog.blog.service;

import com.cgblog.blog.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ArticleService {
    List findAllArticle();

    Article saveArticle(Article article);

    void deleteArticle(Long id);

    Article findArticleById(Long id);

    List findArticleByNameLike(String namelike);

    Page findArticlePage(Pageable pageable);
}
