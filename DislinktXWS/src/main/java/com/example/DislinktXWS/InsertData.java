package com.example.DislinktXWS;

import com.example.DislinktXWS.controller.ProfileController;
import com.example.DislinktXWS.controller.UserController;
import com.example.DislinktXWS.model.*;
import com.example.DislinktXWS.repository.*;
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
    @Autowired
    FollowRequestRepository followRequestRepository;
    
    @Autowired
    UserController userController;




    @PostConstruct
    public void init() {


        //Comment com1=new Comment((long)1,1,"blablablabla");
        //repository.save(com1);
        User user = new User((long)1, "Pera", "Peric", "jova@gmail.com", "pera", "123","29.08.1999.");
        userRepository.save(user);

        User user2 = new User((long)2, "Jova", "Jovic", "jova@gmail.com", "jova", "123","14.11.1999.");
        userRepository.save(user2);

        User user3 = new User((long)3, "Stevan", "Stefanovic", "steva@gmail.com", "steva", "123","14.11.1999.");
        userRepository.save(user3);

        User user33 = new User((long)33, "Rade", "Radic", "steva@gmail.com", "rade", "123","14.11.1999.");
        userRepository.save(user2);


        List<Long> li1 = new ArrayList<>();
        List<Comment> li2 = new ArrayList<>();
        Post post = new Post((long)1, "post test", li1, li1, li2);
        List<Post> posts = new ArrayList<>();
        posts.add(post);

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
        newProfile.setPrivateProfile(false);
        newProfile.setUser(user);


        Profile newProfile2 = new Profile();
        newProfile2.setId((long)2);
        newProfile2.setEducation(list);
        newProfile2.setExperience(list);
        newProfile2.setInterests(list);
        newProfile2.setSkills(list);
        newProfile2.setPrivateProfile(false);
        newProfile2.setUser(user2);


        Profile newProfile3 = new Profile();
        newProfile3.setId((long)3);
        newProfile3.setEducation(list);
        newProfile3.setExperience(list);
        newProfile3.setInterests(list);
        newProfile3.setSkills(list);
        newProfile3.setPrivateProfile(true);
        newProfile3.setUser(user3);

        //Profile profile = new Profile(user,, edu, inter, skill, false);
        profileRepository.save(newProfile);


        //User user33 = userRepository.getByUsername("laza");




        Profile newProfile33 = new Profile();
        newProfile33.setId((long)33);
        newProfile33.setUser(user33);
        newProfile33.setEducation(list);
        newProfile33.setExperience(list);
        newProfile33.setInterests(list);
        newProfile33.setSkills(list);
        newProfile33.setPrivateProfile(false);
        newProfile33.setUser(user33);
        profileRepository.save(newProfile33);

        profileRepository.save(newProfile3);
        profileRepository.save(newProfile2);

        FollowRequest followRequest = new FollowRequest((long)1,"steva","pera",false);
        followRequestRepository.save(followRequest);
    }
}
