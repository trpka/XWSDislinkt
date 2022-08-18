package com.example.DislinktXWS.service;

import com.example.DislinktXWS.model.Comment;
import com.example.DislinktXWS.model.Post;
import com.example.DislinktXWS.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment save(Comment com){
        List<Comment> listOfAll = this.commentRepository.findAll();
        Long id=(long)0;
        for ( Comment c:listOfAll) {
            id=c.getId();
        }
        id=id+1;
        com.setId(id);
        this.commentRepository.save(com);

        return this.commentRepository.save(com);
    }

    public List<Comment> findAll(){
        return this.commentRepository.findAll();
    }
}
