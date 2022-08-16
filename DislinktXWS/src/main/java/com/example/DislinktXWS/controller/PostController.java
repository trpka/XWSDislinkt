package com.example.DislinktXWS.controller;

import com.example.DislinktXWS.model.Post;
import com.example.DislinktXWS.repository.PostRepository;
import com.example.DislinktXWS.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
public class PostController {
    @Autowired
    private PostRepository repository;
    @Autowired
    private PostService postService;

    @RequestMapping(value="api/post",method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post> save(@RequestBody Post post){
        Post savedPost=this.postService.save(post);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }

    @RequestMapping(value = "api/posts/{id}",method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable String id){
        Optional<Post> itemOption=this.postService.findById(id);
        if(!itemOption.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.postService.delete(itemOption.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
