package com.example.DislinktXWS.controller;

import com.example.DislinktXWS.DTO.NewCommentDTO;
import com.example.DislinktXWS.model.Comment;
import com.example.DislinktXWS.model.Post;
import com.example.DislinktXWS.repository.CommentRepository;
import com.example.DislinktXWS.repository.PostRepository;
import com.example.DislinktXWS.service.CommentService;
import com.example.DislinktXWS.service.PostService;
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
    private PostRepository postRepository;
    @Autowired
    private CommentService commentService;
    @Autowired
    private PostService postService;

	@RequestMapping(value="api/comment",method = RequestMethod.GET,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Comment>> findAll(){
		List<Comment> items=this.commentService.findAll();
		return new ResponseEntity<>(items,HttpStatus.OK);
	}
/*
    @RequestMapping(value="api/comment",method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comment> save(@RequestBody Comment comment){
        Comment savedComment=this.repository.save(comment);
        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }*/
    @RequestMapping(value="api/comment",method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post> save(@RequestBody NewCommentDTO newcommentdto){
        Comment newComment=new Comment(newcommentdto.getComment().getUserId(),newcommentdto.getComment().getContent());
        Comment savedComment=this.commentService.save(newComment);//treba napraviti u servisu save takav da daje poslednji id +1, zato sto se radi sa id-jevima koji su tipa long, a mongo ne yna sam daa generise long
        Post post= this.postService.findById(newcommentdto.getPost().getId());
        post.getComments().add(savedComment);
        Post savedPost=this.postRepository.save(post);
        /*for (Comment c: savedPost.getComments()
             ) {
            System.out.print(c.getContent());
        }*/
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }
}
