package com.cgblog.blog.service;

import com.cgblog.blog.domain.Comment;
import com.cgblog.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository repository;

    public Comment save(Comment comment){
        return repository.save(comment);
    }

    public void delete(String id){
        repository.deleteById(id);
    }

    public List showAllComment(Long aid){
        return repository.findAllByAid(aid);
    }
}
