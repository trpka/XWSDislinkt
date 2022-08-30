package com.example.DislinktXWS.service;

import com.example.DislinktXWS.DTO.NewDislikeDTO;
import com.example.DislinktXWS.DTO.NewLikeDTO;


import com.example.DislinktXWS.model.Post;
import com.example.DislinktXWS.model.Profile;
import com.example.DislinktXWS.repository.PostRepository;
import com.example.DislinktXWS.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ProfileRepository profileRepository;


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

    public List<Post> findAllPostsByOwnerId(Long id) {

        List<Post> allPosts = postRepository.findAll();
        List<Post> findedPosts = new ArrayList<>();

        for (Post p:allPosts)
        {
            if(p.getOwnerId() == id)
            {
                findedPosts.add(p);
            }


        }
        return findedPosts;
    }




    public Post likePost1(NewLikeDTO newLikeDTO) {
        Post post = this.findById(newLikeDTO.getLikedPost().getId());
        boolean check = false;
        for(Long l:post.getUserIdWhoLikes())
        {
            if(l.equals(newLikeDTO.getIdProfileWhoLike()))
            {
                check = true;
            }
        }

        if(check == false){
            if (post.getUserIdWhoLikes().size() == 0) {
                List<Long> initList = new ArrayList<>();
                initList.add(newLikeDTO.getIdProfileWhoLike());
                Long numberOfLikes = post.getNumberOfLikes();
                numberOfLikes++;
                post.setNumberOfLikes(numberOfLikes);
                post.setUserIdWhoLikes(initList);
            } else {
                Long numberOfLikes = post.getNumberOfLikes();
                numberOfLikes++;
                post.setNumberOfLikes(numberOfLikes);
                post.getUserIdWhoLikes().add(newLikeDTO.getIdProfileWhoLike());
            }
        }
        else
        {   Long numberOfLikes = post.getNumberOfLikes();
            numberOfLikes--;
            post.setNumberOfLikes(numberOfLikes);
            post.getUserIdWhoLikes().remove(newLikeDTO.getIdProfileWhoLike());
        }

        return postRepository.save(post);
        }

    public Post dislikePost1(NewDislikeDTO newDislikeDTO) {
        Post post = this.findById(newDislikeDTO.getDislikedPost().getId());
        boolean check = false;
        for(Long l:post.getUserIdWhoDislikes())
        {
            if(l.equals(newDislikeDTO.getIdProfileWhoDislike()))
            {
                check = true;
            }
        }

        if(check == false){
            if (post.getUserIdWhoDislikes().size() == 0) {
                List<Long> initList = new ArrayList<>();
                initList.add(newDislikeDTO.getIdProfileWhoDislike());
                Long numberOfDislikes = post.getNumberOfDislikes();
                numberOfDislikes++;
                post.setNumberOfDislikes(numberOfDislikes);
                post.setUserIdWhoDislikes(initList);
            } else {
                Long numberOfDislikes = post.getNumberOfDislikes();
                numberOfDislikes++;
                post.setNumberOfDislikes(numberOfDislikes);
                post.getUserIdWhoDislikes().add(newDislikeDTO.getIdProfileWhoDislike());
            }
        }
        else
        {
            Long numberOfDislikes = post.getNumberOfDislikes();
            numberOfDislikes--;
            post.setNumberOfDislikes(numberOfDislikes);
            post.getUserIdWhoDislikes().remove(newDislikeDTO.getIdProfileWhoDislike());
        }

        return postRepository.save(post);
    }

    public List<Post> findAllPostsFromProfilesYouFollow(Long idProfile){
        //Profile profile = this.profileRepository.findProfileById(idProfile);
        List<Profile> profiles = this.profileRepository.findAll();
        List<Post> posts = this.postRepository.findAll();
        List<Post> findedPosts = new ArrayList<>();
        //Post p3;
        //this.postRepository.findById()

        List<Long> profilesIFollow = new ArrayList<>();
        for(Profile p: profiles)
        {
           for(Long f:p.getFollowers())
           {
               if(f.equals(idProfile))
               {
                   profilesIFollow.add(p.getId());
               }
           }
        }

        for(Long profileIFollow: profilesIFollow)
        {
            for(Post p2 : posts)
            {
                if(profileIFollow.equals(p2.getOwnerId()))
                {
                    findedPosts.add(p2);
                }
            }
        }


        return findedPosts;
    }

}


