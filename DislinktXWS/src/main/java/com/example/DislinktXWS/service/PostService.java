package com.example.DislinktXWS.service;
import com.example.DislinktXWS.model.Comment;
import com.example.DislinktXWS.model.Post;
import com.example.DislinktXWS.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;


    public Post save(Post post){

        List<Post> listOfAll = this.postRepository.findAll();
        Long id=(long)0;
        for ( Post p:listOfAll) {
            id=p.getId();
        }
        id=id+1;
        post.setId(id);
        this.postRepository.save(post);


        return this.postRepository.save(post);
    }

    public Post findById(Long id) {
        Optional<Post> opt=this.postRepository.findById(id);
        if(!opt.isPresent()) {
            return null;
        }
        return opt.get();
    }

    public void delete(Post post) {
        this.postRepository.delete(post);
    }

    public List<Post> findAll() {
       return this.postRepository.findAll();
    }

}
