package com.example.DislinktXWS;

import com.example.DislinktXWS.controller.UserController;
import com.example.DislinktXWS.model.Comment;
import com.example.DislinktXWS.model.Post;
import com.example.DislinktXWS.model.User;
import com.example.DislinktXWS.repository.CommentRepository;
import com.example.DislinktXWS.repository.PostRepository;
import com.example.DislinktXWS.repository.UserRepository;
import com.example.DislinktXWS.service.CommentService;
import com.example.DislinktXWS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class InsertData {
    @Autowired
    CommentRepository repository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;


    @PostConstruct
    public void init() {

        Comment com1=new Comment((long)1,"Dalibor","blablablabla");
        repository.save(com1);
        User user = new User((long)1, "Jovan", "Jovic", "jova@gmail.com", "jovajovic", "sifra123","29.08.1999.");
        userRepository.save(user);

    }
}
