package com.cgblog.blog.controller;

import com.cgblog.blog.common.ShowArticle;
import com.cgblog.blog.domain.Comment;
import com.cgblog.blog.repository.CommentRepository;
import com.cgblog.blog.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;

@Controller
public class CommentController {
    static final Logger LOGGER = LoggerFactory.getLogger(CommentController.class);
    @Autowired
    CommentService service;
    @Autowired
    ShowArticle show;

    @PostMapping("/addComment")
    public String addComment(Comment comment, Model model){
        Date time = new Date();
        comment.setTime(time);
        comment.setId(comment.getAid()+comment.getId()+comment.getTime().toString());
        service.save(comment);
        show.showOne(model,comment.getAid());
        return "article";
    }
}
