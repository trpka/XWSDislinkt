package com.example.DislinktXWS.controller;

import com.example.DislinktXWS.model.Comment;
import com.example.DislinktXWS.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class CommentController {
    @Autowired
    private CommentRepository repository;

    @RequestMapping(value="api/comment",method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comment> save(@RequestBody Comment comment){
        Comment savedComment=this.repository.save(comment);
        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }

    @PostMapping("/addComment")
    public String saveComment(@RequestBody Comment comment){
        repository.save(comment);
        return "Added comment with id" + comment.getId();
    }

    @GetMapping("/findAllComments")
    public List<Comment> getComments(){
        return repository.findAll();
    }
    @GetMapping("/findAllComments/{id}")
    public Optional<Comment> getComment(@PathVariable String id){
        return repository.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteComment(@PathVariable String id){
        repository.deleteById(id);
        return "Comment deleted with id" + id;
    }
}
