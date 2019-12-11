package com.cgblog.blog.repository;

import com.cgblog.blog.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends CrudRepository<Article,Long> {

    @Override
    List<Article> findAll();

    @Override
    Article save(Article s);


}
