package com.cgblog.blog.repository;

import com.cgblog.blog.domain.Comment;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface CommentRepository extends Repository<Comment, String>{

    Comment save(Comment comment);
    List<Comment> findAllByAid(Long aid);
    void deleteById(String id);
}
