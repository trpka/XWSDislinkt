package com.example.DislinktXWS.service;

import com.example.DislinktXWS.model.Post;
import com.example.DislinktXWS.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;


    public Post save(Post post){
        return this.postRepository.save(post);
    }

    public Optional<Post> findById(String id) {

        return this.postRepository.findById(id);
    }

    public void delete(Post post) {
        this.postRepository.delete(post);
    }
}
