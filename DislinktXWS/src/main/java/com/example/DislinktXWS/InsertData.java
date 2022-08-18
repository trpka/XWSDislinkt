package com.example.DislinktXWS;

import com.example.DislinktXWS.model.Comment;
import com.example.DislinktXWS.model.Post;
import com.example.DislinktXWS.repository.CommentRepository;
import com.example.DislinktXWS.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InsertData {
    @Autowired
    CommentRepository repository;

    @PostConstruct
    public void init() {
        Comment com1=new Comment((long)2,"shdasjkd","sdsa");
        //Comment comment = new Comment("stanojko", "kum");


        repository.save(com1);
        //repository.save(comment);

    }
}
