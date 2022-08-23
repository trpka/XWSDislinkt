package com.example.DislinktXWS;

import com.example.DislinktXWS.controller.UserController;
import com.example.DislinktXWS.model.Comment;
import com.example.DislinktXWS.model.Post;
import com.example.DislinktXWS.model.Profile;
import com.example.DislinktXWS.model.User;
import com.example.DislinktXWS.repository.CommentRepository;
import com.example.DislinktXWS.repository.PostRepository;
import com.example.DislinktXWS.repository.ProfileRepository;
import com.example.DislinktXWS.repository.UserRepository;
import com.example.DislinktXWS.service.CommentService;
import com.example.DislinktXWS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class InsertData {
    @Autowired
    CommentRepository repository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    ProfileRepository profileRepository;


    @PostConstruct
    public void init() {


        //Comment com1=new Comment((long)1,1,"blablablabla");
        //repository.save(com1);
        User user = new User((long)1, "Jovan", "Jovic", "jova@gmail.com", "jovajovic", "sifra123","29.08.1999.");
        userRepository.save(user);

        /*List<String> exp = Arrays.asList("work in team", "work online");


        List<String> edu = Arrays.asList("high school", "university");
        List<String> inter = Arrays.asList("programming", "computers");
        List<String> skill = Arrays.asList("quick counting");*/

        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        Profile newProfile = new Profile();
        newProfile.setId((long)1);
        newProfile.setEducation(list);
        newProfile.setExperience(list);
        newProfile.setInterests(list);
        newProfile.setSkills(list);
        newProfile.setPrivate(false);
        newProfile.setUser(user);
        //Profile profile = new Profile(user,, edu, inter, skill, false);
        profileRepository.save(newProfile);
    }
}
