package com.example.DislinktXWS;

import com.example.DislinktXWS.model.Comment;
import com.example.DislinktXWS.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InsertData {
    @Autowired
    CommentService commentService;

    @PostConstruct
    public void init() {
        Comment com1=new Comment("2","shdasjkd","sdsa");
        commentService.save(com1);

    }
}
