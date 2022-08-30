package com.example.DislinktXWS.service;

import com.example.DislinktXWS.model.Post;
import com.example.DislinktXWS.model.Profile;
import com.example.DislinktXWS.model.User;
import com.example.DislinktXWS.repository.ProfileRepository;
import com.example.DislinktXWS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegistrationService
{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProfileService profileService;
    @Autowired
    private ProfileRepository profileRepository;

    public User getByUsername(String username)
    {
        User user = userRepository.getByUsername(username);
        return  user;
    }

    public User registration(User user)
    {
        List<User> listOfAll = this.userRepository.findAll();

        if(userRepository.getByUsername(user.getUsername()) != null)
        {
            System.out.println("Username Already exists! ");
            return null;
        }
        else if (user.getUsername().isEmpty() || user.getFirstName().isEmpty() || user.getLastName().isEmpty() ||
                user.getFirstName().isEmpty())
        {
            System.out.println("There is not enough data! ");
            return null;
        }

        //Automatsko prosledjivanje novog ID-ja
        Long id = (long)0;
        for(User u: listOfAll)
        {
            id = u.getId();
        }
        id = id + 1;
        user.setId(id);

        List list = new ArrayList();
        User user2 = this.userRepository.save(user);
        Profile profile = new Profile();
        profile.setId(user2.getId());
        profile.setUser(user2);
        profile.setFollowers(list);
        profile.setSkills(list);
        profile.setInterests(list);
        profile.setExperience(list);
        profile.setEducation(list);
        profile.setPrivateProfile(false);
        this.profileRepository.save(profile);
        return  new User();
    }


    public List<User> findAll()
    {
        return this.userRepository.findAll();
    }



}
