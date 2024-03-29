package com.cgblog.blog.service;

import com.cgblog.blog.domain.Article;
import com.cgblog.blog.repository.ArticleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    static final Logger LOGGER = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Autowired
    ArticleRepository articleRepository;

    public List findAllArticle(){
        LOGGER.info("findAllArticle");
        return articleRepository.findAll();
    }

    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }

    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    @Cacheable(cacheNames = "article", key = "#id")
    @Override
    public Article findArticleById(Long id) {
        LOGGER.info("findArticleById: "+ id);
        Optional<Article> opt = articleRepository.findById(id);
        if(opt.isPresent()){
            return opt.get();
        }else{
            LOGGER.error("can not find article by: "+ id);
            return null;
        }
    }

    @Override
    public List findArticleByNameLike(String namelike) {
        LOGGER.info("find by name like :" + namelike);
        List<Article> list = articleRepository.findByTitleLike("%" + namelike + "%");
        return list;
    }

    @Override
    public Page findArticlePage(Pageable pageable) {
        LOGGER.info("find artilces in page :" + pageable.getPageNumber());
        Page<Article> page = articleRepository.findAll(pageable);
        return page;
    }


}
