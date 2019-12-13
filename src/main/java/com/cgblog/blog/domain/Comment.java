package com.cgblog.blog.domain;


import org.springframework.stereotype.Controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Comment {

    @Id
    @Column(name = "comment_id")
    private String id;

    @Column(name = "comment_content")
    private String content;

    @Column(name = "comment_name")
    private String name;

    @Column(name = "comment_article")
    private Long aid;

    @Column(name = "comment_time")
    private Date time;

    public Comment() { }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
