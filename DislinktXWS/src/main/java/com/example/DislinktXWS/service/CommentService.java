package com.example.DislinktXWS.service;

import com.example.DislinktXWS.model.Comment;
import com.example.DislinktXWS.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment save(Comment com){
        return this.commentRepository.save(com);
    }
}
